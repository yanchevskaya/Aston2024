package lesson_13.runner;

import io.qameta.allure.Owner;
import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

import static lesson_13.runner.DataTest.*;

/*
Необходимо написать автотесты для сайта mts.by - http://mts.by
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
 */


public class MTSTest extends BaseTest {

    @Test(description = "Check module online-pay name")
    @Owner("AI")
    public void checkModuleNameTest() {

        Assert.assertEquals(getPaymentModule().getModuleName(),
                "Онлайн пополнение\nбез комиссии", "Название неверное");
    }

    @Test(description = "Check if logos in module online-pay are displayed", dataProvider = "logos")
    @Owner("AI")
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
                {5, LOGO_LIST_PAYMENT_MODULE}
        };
    }

    @Test(description = "Check if link works")
    @Owner("AI")
    void checkLinkWorksTest() {

        Assert.assertEquals(getPaymentModule().getURLLinkAboutService(), URL_SERVICE,
                "The link about service doesn't work");

        getPaymentModule().returnToHomePage();
    }

    @Test(description = "Check if link response")
    @Owner("AI")
    void checkLinkResponseTest() {

        Assert.assertTrue(getPaymentModule().checkLinkResponse() < 400);
    }

    @Test(description = "Check payment button operation", dataProvider = "button")
    @Owner("AI")
    void checkButtonWorksTest(String number, String payment) {

        IFrame iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        Assert.assertEquals(iFrame.getPaymentText(), payment + ".00 BYN",
                "Ошибка в сообщении с суммой");

        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {NUMBER, PAYMENT}
        };
    }


    @Test(description = "Check information in placeholders", dataProvider = "connection")
    @Owner("AI")
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
