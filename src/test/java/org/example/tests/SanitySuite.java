package org.example.tests;

import org.example.Listeners.RetryAnalyzer;
import org.example.base.TestBase;
import org.example.pageObjects.HomePage;
import org.example.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.example.Listeners.TestListener.class)
public class SanitySuite extends TestBase {


    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 0, description = "To get the title of the website", enabled = true)
    public void Tc_01_LaunchingBrowswer() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 1, description = "To login to the website")
    public void login() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLoginButton1();
        Thread.sleep(5000);
homePage.validateHomeHeader();
        loginPage.scrollByCordinates();
    }

    @Test(priority = 2, description = "To click last item", enabled = true)
    public void clickLastItemInHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLastItem();
    }

    @Test(priority = 3, description = "To right click and open the item in new tab")
    public void clickLastItemInHomePageFromNewTab() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickBack();
        loginPage.scrollByCordinates();
        Thread.sleep(3000);
        homePage.rightclickLastItemAndOpenInNewTab();
        homePage.switchMultipleWindow("child");
        clickLastItemInHomePage();
        homePage.switchMultipleWindow("parent");
        Thread.sleep(5000);
    }

    @Test(priority = 4, description = "To select the dropdown using select class")
    public void selectDropdowns() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.scrollToTop();
        Thread.sleep(2000);
        homePage.selectDropdown();
        Thread.sleep(5000);
    }
}



