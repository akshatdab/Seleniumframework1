package org.example.tests;

import org.example.base.TestBase;
import org.example.pageObjects.HomePage;
import org.example.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.example.Listeners.TestListener.class)
public class SanitySuite extends TestBase {


    @Test(priority = 0, description ="To get the title of the website", enabled = true)
    public void Tc_01_LaunchingBrowswer(){
        String title = driver.getTitle();
        System.out.println(title);
    }

@Test(priority = 1, description= "To login to the website")
public void login() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage= new HomePage(driver);
    loginPage.enterUserName("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLoginButton1();
    Thread.sleep(5000);
loginPage.scrollByCordinates();
}

@Test(priority = 2, description="To click last item")
    public void clickLastItemInHomePage(){
    HomePage homePage= new HomePage(driver);
    homePage.clickLastItem();
}
}


