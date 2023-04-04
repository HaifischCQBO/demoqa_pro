package Pages;

import Helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_GoogleSearch {
    public WebDriver driver;
    public Helpers helpers;

    // Constructor of the Page_GoogleSearch class that initializes the driver and the helpers instance and initializes all the web elements using PageFactory
    public Page_GoogleSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.helpers = new Helpers(driver);
    }

    // WEB ELEMENTS
// Here are defined all the web elements related to the Google Search page that will be used in the functions defined in this class
    @FindBy(name = "q")
    private WebElement searchInput; // The search input element
    @FindBy(name = "btnK")
    private WebElement searchButton; // The search button element
    @FindBy(id = "wob_tm")
    private WebElement weatherTemperature; // The weather temperature element

    // FUNCTIONS
// Here are defined all the functions that can be performed on the Google Search page
// These functions will be used in the test cases to interact with the page and perform the necessary actions
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
