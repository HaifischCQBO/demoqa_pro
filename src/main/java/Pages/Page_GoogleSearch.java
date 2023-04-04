package Pages;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_GoogleSearch {
    public WebDriver driver;
    public Helpers helpers;

    public Page_GoogleSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT
    @FindBy (name = "q" )
    private WebElement searchInput;
    @FindBy (name = "btnK" )
    private WebElement searchButton;

    @FindBy (id = "wob_tm" )
    private WebElement weatherTemperature;




    // FUNCTIONS // FUNCTIONS // FUNCTIONS // FUNCTIONS // FUNCTIONS // FUNCTIONS // FUNCTIONS // FUNCTIONS

    public WebElement getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(WebElement searchInput) {
        this.searchInput = searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(WebElement searchButton) {
        this.searchButton = searchButton;
    }

    public WebElement getWeatherTemperature() {
        return weatherTemperature;
    }

    public void setWeatherTemperature(WebElement weatherTemperature) {
        this.weatherTemperature = weatherTemperature;
    }
}
