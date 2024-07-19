package lesson_13;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;



/*
Необходимо написать автотесты для сайта mts.by - http://mts.by
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
 */


public class MTSTest extends BaseTest {
    private String url = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private List<String> logolist = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
    private List<String> logoIframeList = List.of("mastercard", "visa", "belkart", "mir", "maestro");

    SoftAssertions softly = new SoftAssertions();


    //1. Проверить название указанного блока
    @Test(description = "Check module online-pay name")
    public void checkModuleNameTest() {
        Assert.assertEquals(getPaymentModule().moduleName.getText(),
                "Онлайн пополнение\nбез комиссии", "Название неверное");
    }

    @Test(description = "Check if logos in module online-pay are displayed", dataProvider = "logos")
    public void checkLogoDisplayedTest(int amount, List<String> logoName) {

        softly.assertThat(getPaymentModule().logoAmount()).isEqualTo(amount);

        for (int i = 0; i < amount; i++) {
            Assert.assertEquals(getPaymentModule().listOfLogosName().get(i),
                    logoName.get(i));
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
        AboutService aboutService = getPaymentModule().clickLinkAboutService();
        Assert.assertEquals(aboutService.getURL(), url, "The link about service doesn't work");
        aboutService.returnToHomePage();
    }

    @Test(description = "Check if link response")
    void checkLinkResponseTest() {
        Assert.assertTrue(getPaymentModule().checkLinkResponse() < 400);
    }

    @Test(description = "Check button", dataProvider = "button")
    void checkButtonWorksTest(String number, String payment) {
        IFrame iFrame = getPaymentModule().buttonClick(number, payment);
        iFrame.wait5(iFrame.paymentText);
        Assert.assertEquals(iFrame.paymentText.getText(), payment + ".00 BYN",
                "Ошибка в сообщении с суммой");
        Assert.assertEquals(iFrame.numberText.getText(), "Оплата: Услуги связи Номер:375" + number,
                "Ошибка в сообщении с номером телефона");
        Assert.assertEquals(iFrame.buttonPay.getText(), "Оплатить " + payment + ".00 BYN",
                "Ошибка в надписи на кнопке");
        iFrame.closeIFrame();
    }

    @Test(description = "Check information", dataProvider = "button")
    void checkInformation(String number, String payment) {

        IFrame iFrame = getPaymentModule().buttonClick(number, payment);
        iFrame.wait5(iFrame.paymentText);
        Assert.assertEquals(iFrame.paymentText.getText(), payment + ".00 BYN",
                "Ошибка в сообщении с суммой");
        Assert.assertEquals(iFrame.numberText.getText(), "Оплата: Услуги связи Номер:375" + number,
                "Ошибка в сообщении с номером телефона");
        Assert.assertEquals(iFrame.cardNumber.getText(), "Номер карты",
                "Ошибка в надписи поля номер карты");
        Assert.assertEquals(iFrame.validity.getText(), "Срок действия",
                "Ошибка в надписи поля срок действия");
        Assert.assertEquals(iFrame.userName.getText(), "Имя держателя (как на карте)",
                "Ошибка в надписи поля имя держателя");
        Assert.assertEquals(iFrame.CVC.getText(), "CVC",
                "Ошибка в надписи поля CVC");
        Assert.assertEquals(iFrame.buttonPay.getText(), "Оплатить " + payment + ".00 BYN",
                "Ошибка в надписи на кнопке");


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
                {"phone", "Номер телефона", "Сумма", "E-mail для отправки чека"},
                {"internet", "Номер абонента", "Сумма", "E-mail для отправки чека"},
                {"instalment", "Номер счета на 44", "Сумма", "E-mail для отправки чека"},
                {"arrears", "Номер счета на 2073", "Сумма", "E-mail для отправки чека"}

        };
    }

    @Test(description = "Check if logos in module online-pay are displayed", dataProvider = "logosIframeInfo")
    public void checkLogoIframeDisplayedTest(int amount, List<String> logoname) {
//        SoftAssertions softAssertions = new SoftAssertions();
        IFrame iFrame = getPaymentModule().buttonClick("297777777", "100");
        iFrame.wait5(iFrame.paymentText);

        Assert.assertEquals(iFrame.logosIframe.size(), amount);

        for (int i = 0; i < logoname.size(); i++) {
            iFrame.wait5(iFrame.logosIframe.get(i));
            Assert.assertTrue(iFrame.logosIframe.get(i).isDisplayed());
            Assert.assertTrue(iFrame.listOfLogosNameIframe().get(i).contains(logoname.get(i)));
        }

        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] logosIframeInfo() {

        return new Object[][]{
                {5, logoIframeList}
        };
    }
}
