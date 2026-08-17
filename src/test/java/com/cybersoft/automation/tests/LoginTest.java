package com.cybersoft.automation.tests;

import com.cybersoft.automation.base.BaseTest;
import com.cybersoft.automation.pages.HomePage;
import com.cybersoft.automation.pages.LoginPage;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {
    @Test
    public void loginSuccess(){

        logger.info("Running auto test: loginSuccess");
        HomePage homePage = new HomePage(driver);

        logger.info("Clicking Login link");
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);

        logger.info("Entering username, password");
        loginPage.login("nguyenpquynh","admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(driver -> !driver.getCurrentUrl().contains("/sign-in"));

        logger.info("Verifying login result");
        Assert.assertFalse(
            driver.getCurrentUrl().contains("/sign-in"),
            "Login failed - User is still on Sign In page"
        );
        logger.info("Login successfully");
    }

    @Test
    public void loginWithInvalidPassword(){

        logger.info("Running auto test, login fail due to invalid password");
        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nguyenpquynh", "pass123");

        logger.info("Verifying test result, login fail");
        Assert.assertTrue(
            driver.getCurrentUrl().contains("/sign-in"),
            "Expected login to fail, but user left Sign In page"
        );
        logger.info("Login fail due to invalid password");
    }
    
    @Test
    public void loginWithEmptyUsename(){

        logger.info("Running auto test, login fail due to EMPTY USERNAME");
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        logger.info("Entering password without Username");
        loginPage.login("", "admin123");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/sign-in"),
            "User should stay on Login Page"
        );

        logger.info("Verifying login without Username completed");

    }

    @Test
    public void loginWithEmptyPassword(){

        logger.info("Running auto test, login fail with EMPTY PASSWORD");
        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);

        logger.info("Entering Username without password");
        loginPage.login("nguyenpquynh", "");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/sign-in"),
            "User should stay on login page"
        );

        logger.info("Verifying login without Password completed");
    
    }

    @Test
    public void loginWithEmptyUsernamePassword(){

        logger.info("Running test: login fail with empty Username and Password");
        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();

        LoginPage loginPage= new LoginPage(driver);

        logger.info("Don't enter Username and Password");
        loginPage.login("", "");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("/sign-in"),
            "User should stay on login page"

        );

        logger.info("Verifying login without both of Username and Password");
    }
}
