package com.yourcompany.automation.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    // Example: locate elements and interactions here
    // private By searchBox = By.id("search");
    // public void enterSearch(String q) { driver.findElement(searchBox).sendKeys(q); }
}
