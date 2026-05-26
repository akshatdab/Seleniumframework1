package org.example.pageObjects;

import org.example.base.PageBase;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }
    String lastItem="//div[text()=\"Test.allTheThings() T-Shirt (Red)\"]";


    public void clickLastItem(){
        if(ElementPresent(lastItem, "Last item is present", 10)) {
            clickElement(lastItem, "Last item is present", 10);
        }
    }
}
