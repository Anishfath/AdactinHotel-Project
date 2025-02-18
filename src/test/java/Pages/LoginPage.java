package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    // Locators
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;


    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(className = "auth_error")
    WebElement errorMessage;
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void login(String username, String password){
        if (usernameField == null || passwordField == null || loginButton == null) {
            throw new IllegalStateException("WebElements are not initialized");
        } 
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

	public boolean isLoginSuccessful() {
		return false;
	}
	 public void login1(String username, String password) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Explicitly wait for the username field to be visible
	        wait.until(ExpectedConditions.visibilityOf(usernameField));
	        usernameField.sendKeys(username);

	        // Explicitly wait for the password field to be visible
	        wait.until(ExpectedConditions.visibilityOf(passwordField));
	        passwordField.sendKeys(password);

	        // Explicitly wait for the login button to be clickable
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	        loginButton.click();
	    }

  
}


