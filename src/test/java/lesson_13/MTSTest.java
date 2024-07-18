package lesson_13;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/*
Необходимо написать автотесты для сайта mts.by - http://mts.by
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
 */


public class MTSTest extends BaseTest {

    @Test(description = "Check module online-pay name")
    public void moduleNameTest() {
        getPaymentModule().checkModuleName();
    }

    @Test(description = "Check if logos in module online-pay are displayed")
    public void isLogoDisplayedTest() {
        getPaymentModule().logoPresence();
    }

    @Test(description = "Check if link works")
    void isLinkWorksTest() {
        getPaymentModule().linkWorks();
    }

    @Test(description = "Check if link response")
    void isLinkResponseTest() {
        getPaymentModule().connectionWorks();
    }

    @Test(description = "Check button", priority = 5, dataProvider = "button")
    void isButtonWorksTest(String number, String payment) {
        getPaymentModule().buttonClick(number,payment);
    }

    @DataProvider
    public Object[][] button() {
        return new Object[][]{
                {"297777777", "100"}
        };

    }
}
