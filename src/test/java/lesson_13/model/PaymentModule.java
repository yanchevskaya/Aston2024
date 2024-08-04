package lesson_13.model;

import io.qameta.allure.Step;
import lesson_13.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PaymentModule extends BasePage {

    public PaymentModule(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "div.pay__wrapper h2")
    private WebElement moduleName;

    @FindBy(id = "cookie-agree")
    private WebElement cookies;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logos;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement link;

    @FindBy(className = "select__wrapper")
    private WebElement chooseOption;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    private WebElement paymentAmountPhone;

    @FindBy(id = "connection-email")
    private WebElement emailPhone;

    @FindBy(xpath = "//form[@id='pay-connection']/button")
    private WebElement buttonContinue;

    @FindBy(id = "internet-phone")
    private WebElement internet;

    @FindBy(id = "internet-sum")
    private WebElement paymentAmountInternet;

    @FindBy(id = "internet-email")
    private WebElement emailInternet;

    @FindBy(id = "score-instalment")
    private WebElement instalment;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSum;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmail;

    @FindBy(id = "score-arrears")
    private WebElement arrears;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSum;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmail;

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement iFrame;


    @Step("Accept cookies")
    public void acceptCookies() {
        waitForVisibility5(cookies);
        cookies.click();
    }

    @Step("Get module name")
    //1. Проверить название указанного блока
    public String getModuleName() {
        return moduleName.getText();
    }

    //2. Проверить наличие логотипов платёжных систем
    @Step("Check number of logos")
    public int logoAmount() {
        return logos.size();
    }

    @Step("Get logos name")
    public List<String> listOfLogosName() {
        List<String> logosName = new ArrayList<>();
        for (WebElement element : logos) {
            logosName.add(element.getAttribute("alt"));
        }
        return logosName;
    }

    //3. Проверить работу ссылки «Подробнее о сервисе»  *first option
    @Step("Click link 'Подробнее о сервисе' and get new page URL")
    public String getURLLinkAboutService() {
        link.click();
        return getWebDriver().getCurrentUrl();
    }

    //*second option
    @Step("Check status code when click link 'Подробнее о сервисе'")
    public int checkLinkResponse() {
        String url = link.getAttribute("href");
        try {
            HttpURLConnection httpURLConnect = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnect.connect();
            return httpURLConnect.getResponseCode();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return 700;
    }

    //Заполнить поля и проверить работу кнопки «Продолжить»
    @Step("Fill fields 'номер телефона:' {number}, 'платёж:' {payment}, click button 'продолжить'")
    public IFrame sendParametersAndButtonClick(String number, String payment) {
        phoneNumber.sendKeys(number);
        paymentAmountPhone.sendKeys(payment);
        buttonContinue.click();
        waitForVisibility5(iFrame);
        getWebDriver().switchTo().frame(iFrame);
        return new IFrame(getWebDriver());
    }

    @Step("Choose {choice}")
    void chooseOptionConnection(String choice) {
        Actions action = new Actions(getWebDriver());

        WebElement option = getWebDriver().findElement(By.xpath("//p[text()='" + choice + "']"));
        chooseOption.click();

        waitForVisibility5(option);

        action.moveToElement(option)
                .click()
                .build()
                .perform();
    }

    @Step("Get information about placeholders")
    String placeholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public ArrayList<String> checkPlaceholderText(String choice) {

        ArrayList<String> listPlaceholders = new ArrayList<>();

        switch (choice) {

            case ("phone"):
                chooseOptionConnection("Услуги связи");
                listPlaceholders.add(placeholder(phoneNumber));
                listPlaceholders.add(placeholder(paymentAmountPhone));
                listPlaceholders.add(placeholder(emailPhone));
                break;

            case ("internet"):
                chooseOptionConnection("Домашний интернет");
                listPlaceholders.add(placeholder(internet));
                listPlaceholders.add(placeholder(paymentAmountInternet));
                listPlaceholders.add(placeholder(emailInternet));
                break;

            case ("instalment"):
                chooseOptionConnection("Рассрочка");
                listPlaceholders.add(placeholder(instalment));
                listPlaceholders.add(placeholder(instalmentSum));
                listPlaceholders.add(placeholder(instalmentEmail));
                break;

            case ("arrears"):
                chooseOptionConnection("Задолженность");
                listPlaceholders.add(placeholder(arrears));
                listPlaceholders.add(placeholder(arrearsSum));
                listPlaceholders.add(placeholder(arrearsEmail));
                break;

            default:
                break;
        }

        return listPlaceholders;
    }

    @Step("Return to Home page")
    public void returnToHomePage() {
        getWebDriver().navigate().back();
    }

}


