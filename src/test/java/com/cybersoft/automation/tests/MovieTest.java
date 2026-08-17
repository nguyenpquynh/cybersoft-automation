package com.cybersoft.automation.tests;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cybersoft.automation.base.BaseTest;
import com.cybersoft.automation.pages.MovieDetailPage;
import com.cybersoft.automation.pages.MoviePage;

public class MovieTest extends BaseTest{

    @Test
    public void verifyMovieListDisplayed(){

        logger.info("Running test: Verify movie list displayed");
        
        MoviePage moviePage = new MoviePage(driver);
        int count = moviePage.getMovieCount();
        System.out.println("Movie count in test: " + count);

        Assert.assertTrue(
            count > 0,
            "Movie list is empty"
        );

        logger.info("List of movies displayed");
    }

    @Test
    public void verifyMovieDetailDisplay(){

        logger.info("Running test: Verify movie detail displayed");

        MoviePage moviePage = new MoviePage(driver);
        moviePage.clickFirstMovie();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver ->driver.getCurrentUrl().contains("/detail/"));
        
        Assert.assertTrue(
            driver.getCurrentUrl().contains("/detail"),
            "Movie detail page is not opened");

        MovieDetailPage movieDetailPage = new MovieDetailPage(driver);
        Assert.assertTrue(
            movieDetailPage.isMovieTitleDisplayed(),
            "Movie Title is not displayed");

        logger.info("Movie detail displayed successfully");
    }

}
