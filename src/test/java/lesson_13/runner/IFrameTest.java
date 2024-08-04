package lesson_13.runner;

import io.qameta.allure.Owner;
import lesson_13.model.IFrame;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static lesson_13.runner.DataTest.*;


public class IFrameTest extends BaseTest {

    private IFrame iFrame;

    public IFrame getiFrame() {
        return iFrame;
    }

    @BeforeMethod
    public void setupIFrame() {
        iFrame = getPaymentModule().sendParametersAndButtonClick(NUMBER, PAYMENT);
    }

    @AfterMethod
    public void closeIFrame() {
        if (iFrame != null) {
            iFrame.closeIFrame();
        }
    }

    @Test(description = "Check information about logos in iFrame", dataProvider = "logosInfo")
    @Owner("AI")
    public void checkLogoTest(int amount, List<String> logoname) {

        Assert.assertEquals(getiFrame().getListLogosName().size(), amount,
                "Wrong amount of logos");

        Assert.assertTrue(getiFrame().checkLogoDisplayed(), "Логотип не отображается");

        for (int i = 0; i < logoname.size(); i++) {

            Assert.assertListContainsObject(getiFrame().getListLogosName(), logoname.get(i),
                    "Wrong logo:  " + logoname.get(i));
        }
    }

    @DataProvider
    public Object[][] logosInfo() {

        return new Object[][]{
                {5, LOGO_LIST_IFRAME}
        };
    }

    @Test(description = "Check field information", dataProvider = "fieldInformation")
    @Owner("AI")
    void checkFieldInformationTest(List<String> expected) {

        List<String> actualField = getiFrame().getListPlaceholderName();

        for (int i = 0; i < actualField.size(); i++) {
            Assert.assertEquals(getiFrame().getListPlaceholderName().get(i), expected.get(i),
                    "The title in field is wrong");
        }
    }

    @DataProvider
    public Object[][] fieldInformation() {
        return new Object[][]{
                {TITLE_FIELD}
        };
    }
}
