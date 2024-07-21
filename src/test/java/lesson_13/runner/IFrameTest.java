package lesson_13.runner;

import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class IFrameTest extends BaseTest {

    private final String NUMBER = "297777777";

    private final String PAYMENT = "100";

    private final List<String> LOGO_LIST = List.of("mastercard", "visa", "belkart", "mir", "maestro");

    private final List<String> TITLE_FIELD = List.of(PAYMENT + ".00 BYN", "Оплата: Услуги связи Номер:375" + NUMBER,
            "Номер карты", "Срок действия", "Имя держателя (как на карте)", "CVC", "Оплатить " + PAYMENT + ".00 BYN");

    @Test(description = "Check if logos in iFrame are displayed", dataProvider = "logosInfo")
    public void checkLogoDisplayedTest(String number, String payment, int amount, List<String> logoname) {

        IFrame iFrame = getPaymentModule().buttonClick(number, payment);

        Assert.assertEquals(iFrame.listLogosNameIframe().size(), amount);

        for (int i = 0; i < logoname.size(); i++) {
            iFrame.wait5(iFrame.logosIframe.get(i));
            Assert.assertTrue(iFrame.logosIframe.get(i).isDisplayed());
            Assert.assertTrue(iFrame.listLogosNameIframe().get(i).contains(logoname.get(i)));
        }
        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] logosInfo() {

        return new Object[][]{
                {NUMBER, PAYMENT, 5, LOGO_LIST}
        };
    }

    @Test(description = "Check field information", dataProvider = "fieldInformation")
    void checkFieldInformationTest(String number, String payment, List<String> expected) {

        IFrame iFrame = getPaymentModule().buttonClick(number, payment);

        List<String> actualField = iFrame.listPlaceholderName();

        for (int i = 0; i < actualField.size(); i++) {
            Assert.assertEquals(iFrame.listPlaceholderName().get(i), expected.get(i));
        }
        iFrame.closeIFrame();
    }

    @DataProvider
    public Object[][] fieldInformation() {
        return new Object[][]{
                {NUMBER, PAYMENT, TITLE_FIELD}
        };
    }
}
