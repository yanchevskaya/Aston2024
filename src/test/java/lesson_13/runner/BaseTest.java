package lesson_13.runner;

import lesson_13.model.PaymentModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {

    private WebDriver webDriver;
    private PaymentModule paymentModule;

    private final String URL = "https://www.mts.by/";

    public PaymentModule getPaymentModule() {
        return paymentModule;
    }

    public WebDriver initializeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    @BeforeTest
    protected void beforeTest() {
        webDriver = initializeDriver(true);
        webDriver.get(URL);
        webDriver.manage().window().maximize();
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
