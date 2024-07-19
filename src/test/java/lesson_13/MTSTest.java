package lesson_13;

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

    //1. Проверить название указанного блока
    @Test(description = "Check module online-pay name")
    public void checkModuleNameTest() {
        Assert.assertEquals(getPaymentModule().moduleName.getText(),
                "Онлайн пополнение\nбез комиссии", "Название неверное");
    }

    @Test(description = "Check if logos in module online-pay are displayed", dataProvider = "logos")
    public void checkLogoDisplayedTest(int amount, List<String> logoName) {
//        SoftAssertions softAssertions = new SoftAssertions();

        Assert.assertEquals(getPaymentModule().logoAmount(), amount);

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

    @Test(description = "Check button", priority = 5, dataProvider = "button")
    void isButtonWorksTest(String number, String payment) {
        IFrame iFrame = getPaymentModule().checkButtonClick(number, payment);
        Assert.assertEquals(iFrame.getTextInfo(), payment + ".00 BYN");
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {"297777777", "100"}
        };

    }
}
