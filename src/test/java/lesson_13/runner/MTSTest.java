package lesson_13.runner;

import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

/*
Необходимо написать автотесты для сайта mts.by - http://mts.by
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
 */


public class MTSTest extends BaseTest {
    private final String URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private final List<String> LOGO_LIST = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

    @Test(description = "Check module online-pay name")
    public void checkModuleNameTest() {

        Assert.assertEquals(getPaymentModule().getModuleName(),
                "Онлайн пополнение\nбез комиссии", "Название неверное");
    }

    @Test(description = "Check if logos in module online-pay are displayed", dataProvider = "logos")
    public void checkLogoDisplayedTest(int amount, List<String> logoName) {

        Assert.assertEquals(getPaymentModule().logoAmount(), amount);

        for (int i = 0; i < amount; i++) {
            Assert.assertEquals(getPaymentModule().listOfLogosName().get(i),
                    logoName.get(i), "Logo payment module mistake");
        }
    }

    @DataProvider
    public Object[][] logos() {
        return new Object[][]{
                {5, LOGO_LIST}
        };
    }

    @Test(description = "Check if link works")
    void checkLinkWorksTest() {

        Assert.assertEquals(getPaymentModule().getURLLinkAboutService(), URL,
                "The link about service doesn't work");

        getPaymentModule().returnToHomePage();
    }

    @Test(description = "Check if link response")
    void checkLinkResponseTest() {

        Assert.assertTrue(getPaymentModule().checkLinkResponse() < 400);
    }

    @Test(description = "Check payment button", dataProvider = "button")
    void checkButtonWorksTest(String number, String payment) {

        IFrame iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        Assert.assertEquals(iFrame.getPaymentText(), payment + ".00 BYN",
                "Ошибка в сообщении с суммой");

        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {"297777777", "100"}
        };
    }

    @Test(description = "Check information in placeholders", dataProvider = "connection")
    void checkPlaceholderTextTest(String option, String number, String amount, String email) {
        List<String> listPlaceholders;

        listPlaceholders = getPaymentModule().checkPlaceholderText(option);

        Assert.assertEquals(listPlaceholders.get(0), number,
                "Wrong information in field name, option: " + option);
        Assert.assertEquals(listPlaceholders.get(1), amount,
                "Wrong information in field sum, option: " + option);
        Assert.assertEquals(listPlaceholders.get(2), email,
                "Wrong information in field email, option: " + option);
    }

    @DataProvider
    public Object[][] connection() {
        String sum = "Сумма";
        String email = "E-mail для отправки чека";

        return new Object[][]{
                {"phone", "Номер телефона", sum, email},
                {"internet", "Номер абонента", sum, email},
                {"instalment", "Номер счета на 44", sum, email},
                {"arrears", "Номер счета на 2073", sum, email}
        };
    }
}
