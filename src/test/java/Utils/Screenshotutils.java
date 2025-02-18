package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshotutils {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Convert web driver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot and save it to a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define the destination directory and file for the screenshot
        File screenshotsDir = new File("./screenshot");
        if (!screenshotsDir.exists()) {
            // Create the directory if it does not exist
            screenshotsDir.mkdir();
        }

        File destFile = new File(screenshotsDir, fileName + ".png");

        try {
            // Copy the screenshot to the destination
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}



