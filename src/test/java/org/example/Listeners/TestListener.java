package org.example.Listeners;

import org.example.base.TestBase;
import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v145.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    ScreenshotUtil sc = new ScreenshotUtil();

    @Override
    public void onTestSuccess(ITestResult result) {

        try {
            TestBase test = (TestBase) result.getInstance();
            WebDriver driver = test.driver;
            sc.takeScreenshot(driver, "Filename");
            System.out.println("Test Passed" + result.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult result) {
        try {
            TestBase test = (TestBase) result.getInstance();
            WebDriver driver = test.driver;
            System.out.println("Test Failed" + result.getName());
            sc.takeScreenshot(driver, "Filename");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
