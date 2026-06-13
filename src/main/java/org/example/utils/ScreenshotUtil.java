package org.example.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

//    WebDriver driver;
//    public ScreenshotUtil(WebDriver driver){
//        this.driver=driver;
//    }
//EXTENTREPORT
    //ALLURE
    //SOFTASSERTION
// config.data(url username password)

    public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        try{
        String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./Screenshots/" + fileName + timestamp + ".png");
        FileUtils.copyFile(src, destination);
            System.out.println("Screenshot taken successfully");
    }
        catch (Exception e){
            e.printStackTrace();
        }
        }
}
