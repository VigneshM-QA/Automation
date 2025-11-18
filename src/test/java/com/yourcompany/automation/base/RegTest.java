package com.yourcompany.automation.base;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RegTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.initDriver();
      //  driver.get(ConfigReader.get("base.url"));
        driver.get(ConfigReader.get("check.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
