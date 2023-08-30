package com.thescore.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicAction {

    private static WebDriver mobileDriver = Driver.getInstance();
    private static Long TIME_OUT_IN_SECONDS = 20L;

    public static void clickMobileElement(WebElement we) {
        waitForElement(we).click();
    }

    public static void clickMobileElementWithOffset(WebElement we, int xOffSet, int yOffSet) {
        waitForElement(we);
        new Actions(mobileDriver).moveToElement(we).moveByOffset(xOffSet, yOffSet).click().build().perform();
    }

    public static void enterText(WebElement we, String text) {
        waitForElement(we).sendKeys(text);
    }

    public static String getMobileElementText(WebElement we) {
        return waitForElement(we).getText();
    }

    public static boolean isMobileElementDisplayed(WebElement we) {
        try {
            return we.isDisplayed();
        } catch (NoSuchElementException nse) {
            return false;
        }
    }

    public static boolean isMobileElementSelected(WebElement we) {
        return waitForElement(we).isSelected();
    }

    public static WebElement waitForElement(WebElement we) {
        return new WebDriverWait(mobileDriver, Duration.ofSeconds(TIME_OUT_IN_SECONDS)).until(ExpectedConditions.visibilityOf(we));
    }

    public static Dimension getScreenDimensions() {
        return mobileDriver.manage().window().getSize();
    }

    public static void scrollDown() {
        Dimension dimension = getScreenDimensions();
        int startPositionX = dimension.width/2;
        int startPositionY = dimension.height/2;

        int endPositionX = dimension.width/2;
        int endPositionY = dimension.height/4;

        new Actions(mobileDriver).moveToLocation(startPositionX, startPositionY)
                .clickAndHold()
                .moveToLocation(endPositionX, endPositionY)
                .release()
                .build().perform();
    }

    public static void pressBack() {
        if(mobileDriver instanceof AndroidDriver) {
            ((AndroidDriver)mobileDriver).pressKey(new KeyEvent(AndroidKey.BACK));
        } else {
            // Not implemented yet!
            throw new IllegalStateException("Not implemented yet!");
        }
    }

    public static void pressEnter() {
        if(mobileDriver instanceof AndroidDriver) {
            ((AndroidDriver)mobileDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
        } else {
            // Not implemented yet!
            throw new IllegalStateException("Not implemented yet!");
        }
    }
}
