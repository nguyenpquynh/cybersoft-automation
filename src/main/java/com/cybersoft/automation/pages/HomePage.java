package com.cybersoft.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginLink = By.cssSelector("a[href='/sign-in']");
    private By registerLink = By.xpath("//h3[normalize-space()='Đăng Ký']/parent::a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickRegister(){
        driver.findElement(registerLink).click();
    }

}
