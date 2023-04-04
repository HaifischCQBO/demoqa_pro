package Tests.demoGoogle;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Objects.Temperature;
import Pages.Page_GoogleSearch;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_WeatherChallenge extends BaseClass {
    @Test
    @Parameters({"weatherCity"})
    public void exampleTest(String weatherCity) {

        Helpers helpers = new Helpers(driver);
        Page_GoogleSearch page_googleSearch = new Page_GoogleSearch(driver);
        WebElement searchInput =  page_googleSearch.getSearchInput();
        helpers.sendText(searchInput, "Weather in" + weatherCity);
        Temperature illapelTemperature =
                new Temperature(Float.parseFloat(page_googleSearch.getWeatherTemperature().getText()));
        System.out.println(illapelTemperature.getTemperature());

    }
}
