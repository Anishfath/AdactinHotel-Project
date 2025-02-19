package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPage;
import Utils.ExcelUtils1;
import Utils.Screenshotutils;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        // Load test data from Excel file
        return ExcelUtils1.getTestData("E:\\Java workspace\\CapstoneProject1\\src\\test\\resources\\LoginData.xlsx");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean isValid) {
        // Initialize LoginPage
        loginPage = new LoginPage(driver);

        // Perform login
        loginPage.login(username, password);

        // Verify login behavior
        if (isValid) {
            Assert.assertTrue(driver.getTitle().contains("Search Hotel"), "Login failed for valid credentials!");
            Screenshotutils.takeScreenshot(driver, "Valid_Login_Success");
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid Login details"), 
                              "Error message not displayed for invalid credentials!");
            Screenshotutils.takeScreenshot(driver, "Invalid_Login_Error");
        }
    }
}
