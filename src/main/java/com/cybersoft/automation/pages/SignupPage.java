package com.cybersoft.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{

    //Locators
    private By taikhoanInput = new By.ById("taiKhoan");
    private By matkhauInput = new By.ById("matKhau");
    private By confirmPassword = new By.ById("confirmPassWord");
    private By hotenInput = new By.ById("hoTen");
    private By emailInput = new By.ById("email");
    private By signupButton = By.cssSelector("button[type='submit']");

    public SignupPage(WebDriver driver){
        super(driver);
    }

    public boolean isFieldsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(driver ->driver.getCurrentUrl().contains("/sign-up"));

        return driver.findElement(taikhoanInput).isDisplayed()
                && driver.findElement(matkhauInput).isDisplayed()
                && driver.findElement(confirmPassword).isDisplayed()
                && driver.findElement(hotenInput).isDisplayed()
                && driver.findElement(emailInput).isDisplayed()
                && driver.findElement(signupButton).isDisplayed();

    }
}
