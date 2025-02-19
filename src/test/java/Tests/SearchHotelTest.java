package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPage;
import Pages.SearchHotelPage;
import Utils.Screenshotutils;

public class SearchHotelTest extends BaseTest {
    private LoginPage loginPage;
    private SearchHotelPage searchHotelPage;

    @DataProvider(name = "hotelSearchData")
    public Object[][] getHotelSearchData() {
        return new Object[][] {
            {"Sydney", "Hotel Creek", "Double", "10-02-2025", "14-02-2025", true},  // Valid data
            {"Sydney", "Hotel Creek", "Double", "10-02-2025", "14-02-2024", false}  // Invalid dates
        };
    }

    @Test(dataProvider = "hotelSearchData")
    public void testHotelSearch(String location, String hotel, String roomType, String checkIn, String checkOut, boolean expectedResult) {
        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        searchHotelPage = new SearchHotelPage(driver);

        // Perform login
        loginPage.login("NivashAnish", "Password");

        // Perform hotel search
        searchHotelPage.searchHotel(location, hotel, roomType, checkIn, checkOut);

        if (expectedResult) {
            // Verify search results are displayed
            Assert.assertTrue(driver.getTitle().contains("Select Hotel"), "Search failed for valid data!");
            Screenshotutils.takeScreenshot(driver, "Valid_Data_Success");
        } else {
            // Verify error message for invalid check-in/check-out dates
            Assert.assertEquals(searchHotelPage.getCheckoutError(),"");
            Screenshotutils.takeScreenshot(driver, "Invalid_Dates_Error");
        }
    }
}
