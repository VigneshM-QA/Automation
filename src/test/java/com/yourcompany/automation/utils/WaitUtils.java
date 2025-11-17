package com.yourcompany.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, long timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitForClickableAndClick(By locator) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForTitleContains(String partialTitle) {
        return wait.until(ExpectedConditions.titleContains(partialTitle));
    }
}
