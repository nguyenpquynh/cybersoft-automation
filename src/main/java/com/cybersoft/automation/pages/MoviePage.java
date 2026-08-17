package com.cybersoft.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MoviePage extends BasePage{

    private By movieLinks = By.cssSelector("a[href*='/detail/']");

    public MoviePage(WebDriver driver){

        super(driver);
    }

    public int getMovieCount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(driver -> driver.findElements(movieLinks).size() > 0);

        int count = driver.findElements(movieLinks).size();
        System.out.println("movie count = " + count);
        return count;
    }

    public void clickFirstMovie(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver ->driver.findElements(movieLinks).size()>0);

        driver.findElements(movieLinks).get(0).click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource().contains("Mua vé"));
    }
    
}
