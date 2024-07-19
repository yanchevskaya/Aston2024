package lesson_13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutService {
    WebDriver webDriver;
    public AboutService(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    String getURL(){
        return webDriver.getCurrentUrl();
    }

    void returnToHomePage(){
        webDriver.navigate().back();
    }
}
