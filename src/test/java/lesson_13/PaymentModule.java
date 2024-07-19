package lesson_13;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class PaymentModule {
    WebDriver webDriver;

    @FindBy(css = "div.pay__wrapper h2")
    WebElement moduleName;

    @FindBy(id = "cookie-agree")
    WebElement cookies;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    List<WebElement> logos;

    @FindBy(linkText = "Подробнее о сервисе")
    WebElement link;

    @FindBy(className = "select__wrapper")
    WebElement chooseOption;
    @FindBy(id = "connection-phone")
    WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    WebElement paymentAmountPhone;

    @FindBy(id = "connection-email")
    WebElement emailPhone;
    @FindBy(xpath = "//form[@id='pay-connection']/button")
    WebElement buttonContinue;

    @FindBy(id = "internet-phone")
    WebElement internet;

    @FindBy(id = "internet-sum")
    WebElement paymentAmountInternet;

    @FindBy(id = "internet-email")
    WebElement emailInternet;

    @FindBy(id = "score-instalment")
    WebElement instalment;

    @FindBy(id = "instalment-sum")
    WebElement instalmentSum;

    @FindBy(id = "instalment-email")
    WebElement instalmentEmail;

    @FindBy(id = "score-arrears")
    WebElement arrears;

    @FindBy(id = "arrears-sum")
    WebElement arrearsSum;

    @FindBy(id = "arrears-email")
    WebElement arrearsEmail;
    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    WebElement iFrame;


    public PaymentModule(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //принять cookies
    void acceptCookies() {
        cookies.click();
    }

    //2. Проверить наличие логотипов платёжных систем
    int logoAmount() {
        return logos.size();
    }

    List<String> listOfLogosName() {
        List<String> logosName = new ArrayList<>();
        for (WebElement element : logos) {
            logosName.add(element.getAttribute("alt"));
        }
        return logosName;
    }

    //3. Проверить работу ссылки «Подробнее о сервисе»  *first option
    AboutService clickLinkAboutService() {
        link.click();
        return new AboutService(webDriver);
    }

    //*second option
    int checkLinkResponse() {
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
    IFrame buttonClick(String number, String payment) {
        phoneNumber.sendKeys(number);
        paymentAmountPhone.sendKeys(payment);
        buttonContinue.click();
        webDriver.switchTo().frame(iFrame);
        return new IFrame(webDriver);
    }

    void chooseOptionConnection(String choice) {
        chooseOption.click();
        webDriver.findElement(By.xpath("//p[text()='" + choice + "']")).click();
    }


    String placeholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    ArrayList<String> checkPlaceholderText(String choice) {

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

}


