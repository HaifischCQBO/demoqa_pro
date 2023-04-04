package Baseclass;

import Helpers.Helpers;
import Helpers.BrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "url", "headless"})
    public void setUp(String browser, String url, String headless) {
        BrowserConfig browserConfig = new BrowserConfig();
        this.driver = browserConfig.setUpBrowser(browser, headless);
        Helpers helpers = new Helpers(driver);
        helpers.getURL(url);
    }

    @AfterMethod
    public void Finished(){
        driver.quit();
    }


}
