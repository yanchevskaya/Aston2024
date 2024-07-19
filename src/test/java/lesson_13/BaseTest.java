package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver webDriver;
    private PaymentModule paymentModule;

    public PaymentModule getPaymentModule() {
        return paymentModule;
    }


    @BeforeTest
    protected void beforeTest() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.mts.by/");
        paymentModule = new PaymentModule(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        paymentModule.acceptCookies();
    }


    @AfterTest
    protected void afterTest() {
        if(webDriver!=null) {
            webDriver.quit();
        }
    }

}
