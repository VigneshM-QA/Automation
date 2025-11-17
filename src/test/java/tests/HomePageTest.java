package com.yourcompany.automation.tests;

import com.yourcompany.automation.base.BaseTest;
import com.yourcompany.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description = "Verify page title of the home page")
    public void verifyHomePageTitle() {
        HomePage home = new HomePage(driver);
        String title = home.getPageTitle();
        System.out.println("Title: " + title);
        // Example assertion: example.com title contains "Example Domain"
        Assert.assertTrue(title.contains("Example Domain"), "Title did not contain expected text");
    }
}
