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
    String backButton ="//button[@class='btn btn_secondary back btn_large inventory_details_back_button']";
    String dropdown="//select[@class='product_sort_container']";
    String homePageHeader="//button[@class='btn btn_primary btn_small btn_inventory ']";


    public void clickLastItem(){
        if(ElementPresent(lastItem, "Last item is present", 10)) {
            clickElement(lastItem, "Last item is present", 10);
        }
    }

    public void clickBack(){
        clickElement(backButton, "navigate back", 10);
    }

    public void rightclickLastItemAndOpenInNewTab(){
        contextClick(lastItem, "Last item right click", 10);
        robotKeyAction(lastItem, "Last item right click", 10);

    }

    public void validateHomeHeader(){
        if (ElementPresent(homePageHeader,"Validate Home header is visible", 10)){
            System.out.println("Element is visible");
        }
    }


    public void selectDropdown() throws InterruptedException {
        selectDropdown(dropdown, 0, 10);
        Thread.sleep(2000);
        selectDropdown(dropdown, 1, 10);
        Thread.sleep(2000);
        selectDropdown(dropdown, 2, 10);
        Thread.sleep(2000);
        selectDropdown(dropdown, 3, 10);

    }

}
