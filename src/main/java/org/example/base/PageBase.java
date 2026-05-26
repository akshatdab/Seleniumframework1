package org.example.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;

public class PageBase {
    public  WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver=driver;
    }


    public void clickElement(String WebElement, String message, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElement)));
        element.click();
        System.out.println(message);
    }

    public boolean ElementPresent(String WebElement, String message, int timeout){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElement)));
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public void scrollPageBYElement(WebElement e){
        Actions action = new Actions(driver);
        action.moveToElement(e).perform();
    }

    public void scrollPageBYElements(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

    }

}
