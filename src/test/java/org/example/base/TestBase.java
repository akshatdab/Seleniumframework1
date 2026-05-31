package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;


    @BeforeClass
    public void browserSetup() throws FileNotFoundException {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

//    @BeforeMethod
//    public void screenshotMethod() throws IOException {
//        ScreenshotUtil sc = new ScreenshotUtil(driver);
//        sc.takeScreenshot("BeforeMethod");
//    }
//
//    @AfterMethod
//    public void screenshotMethod2() throws IOException {
//        ScreenshotUtil sc = new ScreenshotUtil(driver);
//        sc.takeScreenshot("AfterMethod");
//    }
}

