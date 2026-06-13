package org.example.base;

import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    ScreenshotUtil sc = new ScreenshotUtil();

    public void clickElement(String WebElement, String message, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElement)));
            element.click();
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ElementPresent(String WebElement, String message, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WebElement)));
            System.out.println(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public void scrollPageBYElement(WebElement e) {

        try {
            Actions action = new Actions(driver);
            action.moveToElement(e).perform();
            sc.takeScreenshot(driver, "ScrollScreenshot");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void scrollPageBYElements() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)");

    }


    public void contextClick(String locator, String message, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Actions action = new Actions(driver);
            action.contextClick(element).perform();
            sc.takeScreenshot(driver, "rightClickScreenshot");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void robotKeyAction(String locator, String message, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            sc.takeScreenshot(driver, "arrowdownscreenshot");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void switchMultipleWindow(String window) {
        try {
            String getCurrentWindowHandle = driver.getWindowHandle();
            Set<String> allWindowHandle = driver.getWindowHandles();
            Iterator<String> it = allWindowHandle.iterator();
            String parent = it.next();
            String child = it.next();
            if (window.equalsIgnoreCase("child")) {
                driver.switchTo().window(child);
            } else if (window.equalsIgnoreCase("parent")) {
                driver.switchTo().window(parent);
            } else {
                System.out.print("Invalid input");
            }
            sc.takeScreenshot(driver, "NewWindow");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void selectDropdown(String locator, int a, int timeout ){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByIndex(a);
            System.out.println("Selected row number " + a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
