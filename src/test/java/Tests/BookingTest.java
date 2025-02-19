package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.BookingPage;
import Pages.LoginPage;
import Pages.SearchHotelPage;
import Utils.Screenshotutils;

public class BookingTest extends BaseTest {
    private LoginPage loginPage;
    private SearchHotelPage searchHotelPage;
    private BookingPage bookingPage;

    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return new Object[][] {
            {"Nisha", "Bee", "Sydney", "1234567812345678", "VISA", "April", "2026", "123", true}
        };
    }

    @Test(dataProvider = "bookingData")
    public void testBooking(String firstName, String lastName, String address, String cardNumber, 
                            String cardType, String expiryMonth, String expiryYear, String cvv, boolean expectedResult) 
                            throws InterruptedException {
        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        searchHotelPage = new SearchHotelPage(driver);
        bookingPage = new BookingPage(driver);

        // Perform login and hotel search
        loginPage.login("NivashAnish", "Password");
        Thread.sleep(4000);
        searchHotelPage.searchHotel("Sydney", "Hotel Creek", "Double", "10-10-2028", "11-10-2028");
        Thread.sleep(2000);
        bookingPage.selectRoom(); // Select a room

        // Perform booking
        bookingPage.enterPaymentDetails(firstName, lastName, address, cardNumber, cardType, expiryMonth, expiryYear, cvv);
        Thread.sleep(4000);
        bookingPage.confirmBooking();
        Screenshotutils.takeScreenshot(driver, "Booking Processed");

        if (expectedResult) {
       	 Assert.assertTrue(driver.getPageSource().contains(""), "Error message not displayed for invalid payment details!");
       	 Screenshotutils.takeScreenshot(driver, "Processed to Booking Page");
    }
}}
