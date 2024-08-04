package lesson_13.model;


import lesson_13.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class IFrame extends BasePage {

    public IFrame(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    private WebElement paymentTitle;

    @FindBy(xpath = "(//div[@class='pay-description__text']/span)[1]")
    private WebElement numberText;

    @FindBy(className = "header__close-icon")
    private WebElement close;

    @FindBy(xpath = "//div[@class='card-page__card']/button")
    private WebElement buttonPay;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-1 ng-star-inserted']")
    private WebElement cardNumber;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-4 ng-star-inserted']")
    private WebElement validity;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-3 ng-star-inserted']")
    private WebElement userName;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-5 ng-star-inserted']")
    private WebElement CVC;

    @FindBy(xpath = "//div[@class='cards-brands ng-tns-c46-1']//img")
    private List<WebElement> logos;

    @Step("Get information about payment text")
    public String getPaymentText(){

        waitForVisibility5(paymentTitle);

        return paymentTitle.getText();
    }

    @Step("Check that logos are displaying")
    public boolean checkLogoDisplayed(){
        boolean result = false;
        for (WebElement element : logos){
            waitForVisibility5(element);
            result = element.isDisplayed();
        }
        return result;
    }

    @Step("Get logos name")
    public List<String> getListLogosName() {
        waitForVisibility5(paymentTitle);

        List<String> logosName = new ArrayList<>();

        for (WebElement element : logos) {
            logosName.add(element.getAttribute("src"));
        }

        return logosName;
    }

    @Step("Get information about placeholders")
    public List<String> getListPlaceholderName() {
        waitForVisibility5(paymentTitle);

        List<String> filedTitle = new ArrayList<>();

        filedTitle.add(paymentTitle.getText());
        filedTitle.add(numberText.getText());
        filedTitle.add(cardNumber.getText());
        filedTitle.add(validity.getText());
        filedTitle.add(userName.getText());
        filedTitle.add(CVC.getText());
        filedTitle.add(buttonPay.getText());

        return filedTitle;
    }

    @Step("Close iFrame")
    public void closeIFrame() {
        close.click();
        getWebDriver().switchTo().defaultContent();
    }
}

