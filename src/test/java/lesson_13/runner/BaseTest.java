package lesson_13.runner;

import lesson_13.model.PaymentModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {

    private WebDriver webDriver;
    private PaymentModule paymentModule;

    private final String URL = "https://www.mts.by/";

    public PaymentModule getPaymentModule() {
        return paymentModule;
    }


    @BeforeTest
    protected void beforeTest() {
        webDriver = new ChromeDriver();
        webDriver.get(URL);
        paymentModule = new PaymentModule(webDriver);
        paymentModule.acceptCookies();
    }


    @AfterTest
    protected void afterTest() {
        if(webDriver!=null) {
            webDriver.quit();
        }
    }

}
