package lesson_13;

public class Heap {

/*

    @Test(dataProvider = "connection")
    void checkPlaceholderTextPhoneTest(String option, String number, String amount, String email) {
        ArrayList<String> listPlaceholders;

        switch (option) {
            case ("phone"):
                getPaymentModule().chooseOptionConnectionPhone();
                listPlaceholders = getPaymentModule().checkPlaceholderTextPhone();
                break;

            case ("internet"):
                getPaymentModule().chooseInternetOption();
                listPlaceholders = getPaymentModule().checkPlaceholderTextInternet();
                break;

            default: listPlaceholders = new ArrayList<>();
        }
                Assert.assertEquals(listPlaceholders.get(0), number);
                Assert.assertEquals(listPlaceholders.get(1), amount);
                Assert.assertEquals(listPlaceholders.get(2), email);
        }

    @DataProvider
    public Object[][] connection() {
        return new Object[][]{
                {"phone", "Номер телефона", "Сумма", "E-mail для отправки чека"},
                {"internet", "Номер абонента", "Сумма", "E-mail для отправки чека"}
        };
    }


   @FindBy(id = "connection-email")
    WebElement connectionEmailPhone;

    @FindBy(id = "internet-phone")
    WebElement internet;

    @FindBy(id = "internet-sum")
    WebElement paymentAmountInternet;

    @FindBy(id = "internet-email")
    WebElement connectionEmailInternet;


    @FindBy(className = "select__wrapper")
    WebElement chooseOption;

    @FindBy(xpath = "//p[text()='Услуги связи']")
    WebElement phoneConnectionOption;

    @FindBy(xpath = "//p[text()='Домашний интернет']")
    WebElement internetOption;

     void chooseOptionConnectionPhone() {
        chooseOption.click();
        phoneConnectionOption.click();
    }

    void chooseInternetOption() {
        chooseOption.click();
        internetOption.click();
    }

    ArrayList<String> checkPlaceholderTextPhone(){
        String placeholder = "placeholder";
        ArrayList<String> placeholderText = new ArrayList<>();
        placeholderText.add(phoneNumber.getAttribute(placeholder));
        placeholderText.add(paymentAmountPhone.getAttribute(placeholder));
        placeholderText.add(connectionEmailPhone.getAttribute(placeholder));
        return placeholderText;
    }

    ArrayList<String> checkPlaceholderTextInternet(){
        String placeholder = "placeholder";
        ArrayList<String> placeholderText = new ArrayList<>();
        placeholderText.add(internet.getAttribute(placeholder));
        placeholderText.add(paymentAmountInternet.getAttribute(placeholder));
        placeholderText.add(connectionEmailInternet.getAttribute(placeholder));
        return placeholderText;
    }


 */

}
