package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
    WebDriver driver;

    // Locators
    @FindBy(id = "radiobutton_0")
    WebElement selectRoomButton;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "first_name")
    WebElement firstNameField;

    @FindBy(id = "last_name")
    WebElement lastNameField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "cc_num")
    WebElement cardNumberField;

    @FindBy(id = "cc_type")
    WebElement cardTypeDropdown;

    @FindBy(id = "cc_exp_month")
    WebElement cardExpiryMonthDropdown;

    @FindBy(id = "cc_exp_year")
    WebElement cardExpiryYearDropdown;

    @FindBy(id = "cc_cvv")
    WebElement cvvField;

    @FindBy(id = "book_now")
    WebElement bookNowButton;

    @FindBy(id = "order_no")
    WebElement orderNumber;

    // Constructor
    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void selectRoom() {
        selectRoomButton.click();
        continueButton.click();
    }

    public void enterPaymentDetails(String firstName, String lastName, String address,String cardNumber, String cardType, String expiryMonth, String expiryYear, String cvv) throws InterruptedException {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
    cardNumberField.sendKeys(cardNumber);
    cardTypeDropdown.sendKeys(cardType);
    cardExpiryMonthDropdown.sendKeys(expiryMonth);
    cardExpiryYearDropdown.sendKeys(expiryYear);
    cvvField.sendKeys(cvv);
    }

    public void confirmBooking() throws InterruptedException {
        bookNowButton.click();
        Thread.sleep(2000);
    }
    public String getOrderNumber() {
        return orderNumber.getAttribute("value");
    }
}




