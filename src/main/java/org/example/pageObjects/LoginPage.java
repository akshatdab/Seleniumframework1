package org.example.pageObjects;

import org.example.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    WebDriver driver;

    String username = "//input[@class='input_error form_input']";
    String password = "(//input[@class='input_error form_input'])[2]";
    String LoginButton = "//input[@type='submit']";
    String redTshirt= "(//div[@class='inventory_item_name '])[last()]";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterUserName(String user) {
        driver.findElement(By.xpath(username)).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(By.xpath(password)).sendKeys(pass);

    }
    public void clickLoginButton1() {
        if(ElementPresent(LoginButton, "Verify that user is able to clickLoginButton", 10));
        clickElement(LoginButton, "Verify that user is able to clickLoginButton", 10);
    }


    public void selectLastItems() {
        WebElement e = driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[last()]"));
        scrollPageBYElement(e);
        if (ElementPresent(redTshirt, "Verify last item is present", 10)) {
            clickElement(redTshirt, "Verify last item is present", 10);
        }
    }

    public void scrollByCordinates(){
        scrollPageBYElements();
    }
}
