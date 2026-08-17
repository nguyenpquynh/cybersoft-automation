package com.cybersoft.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtiils {

    public static String captureScreenshot(WebDriver driver, String testname){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String screenshotPath = "screenshot/" + testname + "_" + timestamp + ".png";

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotPath);

        try{
            //taoj folder screenshots neu chua co
            destination.getParentFile().mkdirs();

            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException e) {
            throw new RuntimeException("Cannot save screenshot: " + screenshotPath, e);
        }
        return screenshotPath;

    }
    
}
 