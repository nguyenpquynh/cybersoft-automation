package com.cybersoft.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //locators
    private By usernameInput = By.id("taiKhoan");
    private By passwordInput = By.id("matKhau");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void enterUsername(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}