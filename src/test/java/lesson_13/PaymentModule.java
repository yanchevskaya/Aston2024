package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class PaymentModule {
    WebDriver webDriver;

    @FindBy(css = "div.pay__wrapper h2")
    WebElement moduleName;

    @FindBy(id = "cookie-agree")
    WebElement cookies;

    @FindBy(xpath = "//div[@class='pay__partners']/img")
    List<WebElement> logos;

    @FindBy(linkText = "Подробнее о сервисе")
    WebElement link;

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    WebElement iFrame;

    @FindBy(id = "connection-phone")
    WebElement phoneNumber;

    @FindBy(id = "connection-sum")
    WebElement paymentAmount;

    @FindBy(xpath = "//form[@id='pay-connection']/button")
    WebElement buttonContinue;

    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    WebElement paymentText;

    public PaymentModule(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //принять cookies
    void acceptCookies() {
        cookies.click();
    }

    //1. Проверить название указанного блока
    void checkModuleName() {
        Assert.assertEquals(moduleName.getText(),
                "Онлайн пополнение\nбез комиссии", "Название неверное");
    }

    //2. Проверить наличие логотипов платёжных систем
    void logoPresence() {
        for (WebElement element : logos) {
            Assert.assertTrue(element.isDisplayed(), "Ошибка в отображении лого");
        }
    }

    //3. Проверить работу ссылки «Подробнее о сервисе»  *first option
    void linkWorks() {
        link.click();
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                "The link doesn't work");
        webDriver.navigate().back();
    }

    //*second option
    void connectionWorks() {
        String url = link.getAttribute("href");
        try {
            HttpURLConnection httpURLConnect = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnect.connect();
            Assert.assertTrue(httpURLConnect.getResponseCode() < 400);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    //Заполнить поля и проверить работу кнопки «Продолжить»
    void buttonClick(String number, String payment) {
        phoneNumber.sendKeys(number);
        paymentAmount.sendKeys(payment);
        buttonContinue.click();
        webDriver.switchTo().frame(iFrame);

   //без явного ожидания тест падает
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(paymentText));

        Assert.assertEquals((paymentText).getText(), payment + ".00 BYN");


    }
}


