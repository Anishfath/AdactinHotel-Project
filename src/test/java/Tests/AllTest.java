package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllTest {

    public static ExtentReports extent;
    public static ExtentTest test;

    // Set up ExtentReports
    @BeforeClass
    public static void setupExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system information
        extent.setSystemInfo("Tester", "Anish Fathima");
        extent.setSystemInfo("Environment", "QA");
    }

    // Test 1: Login Test
    @Test
    public void testLogin() {
        test = extent.createTest("Login Test");

        try {
            // Simulate login logic
            test.info("Navigating to login page...");
            boolean isLoginSuccessful = true; // Replace with actual login check

            if (isLoginSuccessful) {
                test.pass("Login successful");
            } else {
                test.fail("Login failed");
            }
        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    // Test 2: Search Hotel Test
    @Test
    public void testSearchHotel() {
        test = extent.createTest("Search Hotel Test");

        try {
            // Simulate search hotel logic
            test.info("Searching for hotels...");
            boolean isHotelFound = true; // Replace with actual hotel search check

            if (isHotelFound) {
                test.pass("Hotel found");
            } else {
                test.fail("Hotel not found");
            }
        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    // Test 3: Booking Test
    @Test
    public void testBooking() {
        test = extent.createTest("Booking Test");

        try {
            // Simulate booking logic
            test.info("Proceeding with booking...");
            boolean isBookingSuccessful = true; // Replace with actual booking status check

            if (isBookingSuccessful) {
                test.pass("Booking successful");
            } else {
                test.fail("Booking failed");
            }
        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    // Tear down ExtentReports
    @AfterClass
    public static void tearDownExtentReports() {
    extent.flush();    
}
}

