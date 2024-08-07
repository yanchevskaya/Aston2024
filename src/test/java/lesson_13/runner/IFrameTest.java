package lesson_13.runner;

import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Stream;

public class IFrameTest extends BaseTest {

    private final String NUMBER = "297777777";

    private final String PAYMENT = "100";

    private final List<String> LOGO_LIST = List.of(
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg");


    private final List<String> TITLE_FIELD = List.of(PAYMENT + ".00 BYN", "Оплата: Услуги связи Номер:375" + NUMBER,
            "Номер карты", "Срок действия", "Имя держателя (как на карте)", "CVC", "Оплатить " + PAYMENT + ".00 BYN");

    @Test(description = "Check information about logos in iFrame", dataProvider = "logosInfo")
    public void checkLogoTest(String number, String payment, int amount, List<String> logoname) {

        IFrame iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        Assert.assertEquals(iFrame.getListLogosName().size(), amount,
                "Wrong amount of logos");

        Assert.assertTrue(iFrame.checkLogoDisplayed(), "Логотип не отображается");

        for (int i = 0; i < logoname.size(); i++) {

            Assert.assertListContainsObject(iFrame.getListLogosName(), logoname.get(i),
                    "Wrong logo:  " + logoname.get(i));
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

        IFrame iFrame = getPaymentModule().sendParametersAndButtonClick(number, payment);

        List<String> actualField = iFrame.getListPlaceholderName();

        for (int i = 0; i < actualField.size(); i++) {
            Assert.assertEquals(iFrame.getListPlaceholderName().get(i), expected.get(i),
                    "The title in field is wrong");
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
