package com.cybersoft.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MovieDetailPage extends BasePage {

    private By movieTitle = By.cssSelector("h4,h3,h2,h1");
    private By buyTicketBtn= By.name("Mua vé");
    public MovieDetailPage(WebDriver driver){
        super(driver);
    }
    
    public boolean isMovieTitleDisplayed(){
        return driver.findElement(movieTitle).isDisplayed();
    }

    public boolean isBuyTiketBtnDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(driver ->driver.getCurrentUrl().contains("/detail/"));

        return driver.findElement(buyTicketBtn).isDisplayed();
    }

    public void clickMuaVe(){
        driver.findElement(buyTicketBtn).click();
    }
}
