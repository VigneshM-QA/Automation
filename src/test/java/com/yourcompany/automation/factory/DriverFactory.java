package com.yourcompany.automation.factory;

import com.yourcompany.automation.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        String browser = ConfigReader.get("browser");
        WebDriver driver;

        switch (browser == null ? "chrome" : browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
        }

        int implicit = ConfigReader.getInt("implicit.wait", 10);
        int pageLoad = ConfigReader.getInt("page.load.timeout", 30);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoad));
        driver.manage().window().maximize();

        tlDriver.set(driver);
        return driver;
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
