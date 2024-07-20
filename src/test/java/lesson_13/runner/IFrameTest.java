package lesson_13.runner;

import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class IFrameTest extends BaseTest {

    private String number = "297777777";
    private String payment = "100";
    private List<String> logoIframeList = List.of("mastercard", "visa", "belkart", "mir", "maestro");

    private List<String> titleFieldIFrame = List.of(payment+".00 BYN", "Оплата: Услуги связи Номер:375"+number, "Номер карты",
            "Срок действия", "Имя держателя (как на карте)", "CVC", "Оплатить "+payment+".00 BYN");

    @Test(description = "Check if logos in module online-pay are displayed", dataProvider = "logosIframeInfo")
    public void checkLogoIframeDisplayedTest(String number, String payment, int amount, List<String> logoname) {

        IFrame iFrame = getPaymentModule().buttonClick(number, payment);
        iFrame.wait5(iFrame.paymentText);

        Assert.assertEquals(iFrame.logosIframe.size(), amount);

        for (int i = 0; i < logoname.size(); i++) {
            iFrame.wait5(iFrame.logosIframe.get(i));
            Assert.assertTrue(iFrame.logosIframe.get(i).isDisplayed());
            Assert.assertTrue(iFrame.listLogosNameIframe().get(i).contains(logoname.get(i)));
        }

        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] logosIframeInfo() {

        return new Object[][]{
                {number, payment, 5, logoIframeList}
        };
    }

        @Test(description = "Check field information", dataProvider = "fieldInformation")
    void checkFieldInformationTest(String number, String payment, List<String> expected) {

        IFrame iFrame = getPaymentModule().buttonClick(number, payment);
        iFrame.wait5(iFrame.paymentText);

        List<String> actualField = iFrame.listPlaceholderName();

        for (int i = 0; i < actualField.size(); i++) {
            Assert.assertEquals(iFrame.listPlaceholderName().get(i), expected.get(i));
        }
            iFrame.closeIFrame();

    }

        @DataProvider
    public Object[][] fieldInformation() {
        return new Object[][]{
                {number, payment, titleFieldIFrame}
        };
    }

}
