package lesson_13.runner;

import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
Необходимо написать автотесты для сайта mts.by - http://mts.by
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
 */


public class MTSTest extends BaseTest {
    private String url = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private List<String> logolist = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

    private String sum = "Сумма";
    private String email = "E-mail для отправки чека";



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
                {5, logolist}
        };
    }

    @Test(description = "Check if link works")
    void checkLinkWorksTest() {
        Assert.assertEquals(getPaymentModule().getURLLinkAboutService(), url,
                "The link about service doesn't work");
        getPaymentModule().returnToHomePage();
    }

    @Test(description = "Check if link response")
    void checkLinkResponseTest() {
        Assert.assertTrue(getPaymentModule().checkLinkResponse() < 400);
    }

    @Test(description = "Check payment button", dataProvider = "button")
    void checkButtonWorksTest(String number, String payment) {
        IFrame iFrame = getPaymentModule().buttonClick(number, payment);
        getPaymentModule().wait5(iFrame.paymentText);
        Assert.assertEquals(iFrame.paymentText.getText(), payment + ".00 BYN",
                "Ошибка в сообщении с суммой");

        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {"297777777", "100"}
        };
    }

    @Test(dataProvider = "connection")
    void checkPlaceholderTextPhoneTest(String option, String number, String amount, String email) {
        ArrayList<String> listPlaceholders;

        listPlaceholders = getPaymentModule().checkPlaceholderText(option);

        Assert.assertEquals(listPlaceholders.get(0), number);
        Assert.assertEquals(listPlaceholders.get(1), amount);
        Assert.assertEquals(listPlaceholders.get(2), email);
    }


    @DataProvider
    public Object[][] connection() {
        return new Object[][]{
                {"phone", "Номер телефона", sum,email},
                {"internet", "Номер абонента", sum,email},
                {"instalment", "Номер счета на 44", sum,email},
                {"arrears", "Номер счета на 2073", sum,email}

        };
    }
}
