package lesson_13;

import com.beust.ah.A;
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

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    WebElement iFrame;

    @FindBy(id = "connection-phone")
    WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    WebElement paymentAmountPhone;

    @FindBy(xpath = "//form[@id='pay-connection']/button")
    WebElement buttonContinue;

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
    IFrame checkButtonClick(String number, String payment) {
        phoneNumber.sendKeys(number);
        paymentAmountPhone.sendKeys(payment);
        buttonContinue.click();
        webDriver.switchTo().frame(iFrame);
        return new IFrame(webDriver);
    }
}


