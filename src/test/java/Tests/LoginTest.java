package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import Utils.ExcelUtils1;
import Utils.Screenshotutils;

public class LoginTest  {

    WebDriver driver;
    LoginPage loginPage;

    // DataProvider method for TestNG to provide data
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        // Return the data from the Excel file
        return ExcelUtils1.getTestData("E:\\Java workspace\\CapstoneProject1\\src\\test\\resources\\LoginData.xlsx");
    }

    // Test method that uses data from the DataProvider
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean isValid)  {
    	 // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize window and navigate to Adactin Hotel website
        driver.manage().window().maximize();
        // Navigate to login page
        driver.get("https://adactinhotelapp.com/");
        // Initialize LoginPage
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Verify login behavior
        if (isValid) {
            Assert.assertTrue(driver.getTitle().contains("Search Hotel"), "Login failed for valid credentials!");
            Screenshotutils.takeScreenshot(driver, "Valid_Login_Success");
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid Login details"), "Error message not displayed for invalid credentials!");
        
            Screenshotutils.takeScreenshot(driver, "Invalid_Login_Error");
            }

      driver.quit();
    }
}
