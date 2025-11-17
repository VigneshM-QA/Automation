package pages;

import org.openqa.selenium.WebDriver;

public class RegressionPage {
    private WebDriver driver;

    public RegressionPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    // Example: locate elements and interactions here
    // private By searchBox = By.id("search");
    // public void enterSearch(String q) { driver.findElement(searchBox).sendKeys(q); }
}
