package com.cybersoft.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cybersoft.automation.base.BaseTest;
import com.cybersoft.automation.pages.HomePage;
import com.cybersoft.automation.pages.SignupPage;

public class SignupTest extends BaseTest{

    @Test
    public void verifySignupBtn(){

        logger.info("Start testing: Verify signup button");
        HomePage homePage = new HomePage(driver);

        logger.info("Clcik on Sign Up button");
        homePage.clickRegister();
        logger.info("Verify the result");
        Assert.assertTrue(
            driver.getCurrentUrl().contains("/sign-up"),
        "User is still on Homepage");
    }
    
    @Test
    public void verifySignupForm(){

        logger.info("Start testing: Verify Signup Form");
        HomePage homePage = new HomePage(driver);

        logger.info("Click on SignUp button");
        homePage.clickRegister();

        SignupPage signupPage = new SignupPage(driver);

        logger.info("Verify test result");
        Assert.assertTrue(signupPage.isFieldsDisplayed(), "Signup fields are not displayed");

        logger.info("Verify test result - Ended");
    }
}
