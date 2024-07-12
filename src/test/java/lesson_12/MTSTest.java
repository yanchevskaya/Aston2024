package lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;


public class MTSTest {
private WebDriver webDriver;

    @BeforeTest
    protected void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.get("https://www.mts.by/");
    }

    @AfterTest
    protected void afterMethod() {
        if(webDriver!=null) {
            webDriver.quit();
        }
    }

    @Test (description = "Check module name")
    public void moduleNameTest() {
        Assert.assertEquals(webDriver.findElement(By.cssSelector("div.pay__wrapper h2")).getText(),
                "Онлайн пополнение\nбез комиссии", "Отображение имени");
    }   //        System.out.println(webDriver.findElement(By.xpath("//div[@class='pay__wrapper']//h2")).getText());

    @Test (description = "Check if logos are displayed")
    public void isLogoDisplayedTest() {
        List<WebElement> test = webDriver.findElements(By.xpath("//div[@class='pay__partners']//img"));

        for (WebElement element : test) {
            Assert.assertTrue(element.isDisplayed());
        }

        Assert.assertTrue(webDriver.findElement
                (By.xpath("//div[@class='pay__partners']//img")).isDisplayed(),
                "Наличие лого");

    }
}

