package com.cybersoft.automation.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cybersoft.automation.utils.ScreenshotUtiils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
        logger.info("====Start auto test");
        logger.info("Opening Chrome browser");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE)
        {
            logger.error("Test failed: {}", result.getName());

            ScreenshotUtiils.captureScreenshot(driver, result.getName());
        }

        if (driver != null){
            logger.info("Closing browser");
            driver.quit();
        }

        logger.info("END-----TEST--------");
    }
}