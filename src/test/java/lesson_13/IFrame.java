package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IFrame {
    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    WebElement paymentText;

    @FindBy(xpath = "(//div[@class='pay-description__text']/span)[1]")
    WebElement numberText;

    @FindBy(className = "header__close-icon")
    WebElement close;

    @FindBy(xpath = "//button[@class='colored disabled']")
    WebElement buttonPay;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-1 ng-star-inserted']")
    WebElement cardNumber;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-4 ng-star-inserted']")
    WebElement validity;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-3 ng-star-inserted']")
    WebElement userName;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-5 ng-star-inserted']")
    WebElement CVC;

    @FindBy(xpath = "//div[@class='cards-brands ng-tns-c46-1']//img")
    List<WebElement> logosIframe;

    WebDriver webDriver;

    public IFrame(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    void wait5(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

     List<String> listOfLogosNameIframe() {
        List<String> logosName = new ArrayList<>();
        for (WebElement element : logosIframe) {
            logosName.add(element.getAttribute("src"));
        }
        return logosName;
    }

    void closeIFrame() {
        close.click();
        webDriver.navigate().refresh();
    }
}

