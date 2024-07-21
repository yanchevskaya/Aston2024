package lesson_13.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {

    private final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected WebDriver getWebDriver(){
        return webDriver;
    }

    public void wait5(WebElement webElement) {
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
