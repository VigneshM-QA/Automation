package tests;

import com.yourcompany.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegressionPage;

public class NewRegressionTest extends BaseTest {

    @Test(description = "Verify the google page")
    public void verifyRegressionPage() {

        RegressionPage home = new RegressionPage(driver);
        String url = home.getURL();
        System.out.println("url:" + url);
        Assert.assertTrue(url.contains("com"),"Correct URL handled");

    }
}
