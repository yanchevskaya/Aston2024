package lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MTSTest {
    private WebDriver webDriver;

    @BeforeTest
    protected void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.mts.by/");
        webDriver.findElement(By.id("cookie-agree")).click();
    }

    @AfterTest
    protected void afterMethod() {
        if(webDriver!=null) {
            webDriver.quit();
        }
    }

    @Test(description = "Check module online-pay name")
    public void moduleNameTest() {
        Assert.assertEquals(webDriver.findElement(By.cssSelector("div.pay__wrapper h2")).getText(),
                "Онлайн пополнение\nбез комиссии", "Отображение имени");
    }

    @Test(description = "Check if logos in module online-pay are displayed")
    public void isLogoDisplayedTest() {
        List<WebElement> test = webDriver.findElements(By.xpath("//div[@class='pay__partners']/img"));

        for (WebElement element : test) {
            Assert.assertTrue(element.isDisplayed(), "наличие лого");
        }
    }
    @Test(description = "Check if link works")
    void isLinkWorks() {

        //first option
        webDriver.findElement(By.linkText("Подробнее о сервисе")).click();
        webDriver.findElement(By.name(""));
        Assert.assertEquals(webDriver.getCurrentUrl(), "", "");
        webDriver.navigate().back();


        //second option
        String url = webDriver.findElement(By.linkText("Подробнее о сервисе")).getAttribute("href");
        try{
            HttpURLConnection httpURLConnect = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnect.connect();
            Assert.assertTrue(httpURLConnect.getResponseCode() < 400);
        } catch (Exception e){
            e.getStackTrace();    }
    }

    void isButtonWorks() {

        webDriver.findElement(By.id("connection-phone")).sendKeys("297777777");    webDriver.findElement(By.id("connection-sum")).sendKeys("100");
        webDriver.findElement(By.xpath("//form[@id='pay-connection']/button")).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));


        WebElement iframe = webDriver.findElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.id("cc-number")).sendKeys("13212312");    System.out.println(webDriver.findElement(By.xpath("(//div[@class='pay-description__cost']/span)[1]")).getText());
    }
}

