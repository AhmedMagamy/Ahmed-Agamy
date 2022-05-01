package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ReportsUtility.ExtentReport.fail;

public class UiActions
{
    private WebDriver driver;

    public UiActions(WebDriver driver) {
        this.driver = driver;
    }

    public static void type(WebDriver driver, By elementLocator, String text) {
        locateElement(driver, elementLocator);
        try {
            Logger.logMessage("[UI Action] Clear and Type [" + text + "] on element [" + elementLocator + "]");
            //clear the text field
            driver.findElement(elementLocator).clear();
            //then type
            driver.findElement(elementLocator).sendKeys(text);
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
    }

    public static void click(WebDriver driver, By elementLocator) {
        locateElement(driver, elementLocator);
        try {
            //wait for element to be clickable
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(elementLocator));
            Logger.logMessage("[UI Action] click on element [" + elementLocator + "]");
            //click on the element
            driver.findElement(elementLocator).click();
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
    }
    public static void locateElement(WebDriver driver,By elementLocator){
        try {
            // Wait for the element to be visible
            new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
            // Scroll the element into view to handle some browsers cases
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
                    driver.findElement(elementLocator));
            // Check if the element is displayed
            if (!driver.findElement(elementLocator).isDisplayed()) {
                Logger.logMessage("The element [" + elementLocator.toString() + "] is not Displayed");
                fail("The element [" + elementLocator.toString() + "] is not Displayed");
            }
        } catch (TimeoutException toe) {
            Logger.logMessage(toe.getMessage());
            fail(toe.getMessage());
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
    }

    public static void select(WebDriver driver, By elementLocator, String selectType, String option) {
        locateElement(driver, elementLocator);
        try {
            Select s = new Select(driver.findElement(elementLocator));
            Logger.logMessage("[UI Action] Select [" + option + "] on element [" + elementLocator + "]");
            switch (selectType) {
                case "text" -> s.selectByVisibleText(option);
                case "value" -> s.selectByValue(option);
                default -> Logger.logMessage("Unexpected value: " + selectType);
            }
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
            fail(e.getMessage());
        }
    }

    }


