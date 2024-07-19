package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFrame {
    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    WebElement paymentText;

    WebDriver webDriver;
    public IFrame(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    //без явного ожидания тест падает
    String getTextInfo() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(paymentText));

        return paymentText.getText();
    }


}
