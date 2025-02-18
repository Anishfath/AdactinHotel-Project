package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
    WebDriver driver;
    // Locators
    @FindBy(id = "location")
    WebElement locationDropdown;

    @FindBy(id = "hotels")
    WebElement hotelsDropdown;

    @FindBy(id = "room_type")
    WebElement roomTypeDropdown;

    @FindBy(id = "datepick_in")
    WebElement checkInDate;

    @FindBy(id = "datepick_out")
    WebElement checkOutDate;

    @FindBy(id = "Submit")
    WebElement searchButton;
    
    @FindBy(className = "reg_error")
    WebElement checkoutError;
    @FindBy(className = "reg_error")
    WebElement InvalidLocationError;


    // Constructor
    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void searchHotel(String location, String hotel, String roomType) {
        locationDropdown.sendKeys(location);
        hotelsDropdown.sendKeys(hotel);
        roomTypeDropdown.sendKeys(roomType);
        searchButton.click();
    }

    public void searchHotel(String location, String hotel, String roomType, String checkIn, String checkOut) {
        locationDropdown.sendKeys(location);
        hotelsDropdown.sendKeys(hotel);
        roomTypeDropdown.sendKeys(roomType);
        checkInDate.clear();
        checkInDate.sendKeys(checkIn);
        checkOutDate.clear();
        checkOutDate.sendKeys(checkOut);
        searchButton.click();
    }

    public String getCheckoutError() {
        return checkoutError.getText();
    }
    public String getInvalidLocationError() {
        return InvalidLocationError.getText();
    }

	public String getErrorMessage() {
		return null;
	}

	public void login(String string, String string2) {
		
	}
}



