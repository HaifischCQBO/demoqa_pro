package Tests.demoGoogle;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Objects.Temperature;
import Objects.Weather;
import Pages.Page_GoogleSearch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_WeatherChallenge extends BaseClass {

    @Test
    @Parameters({"weatherCity", "apiKey"})
    public void weatherChallenge(String weatherCity, String apiKey) throws Weather.WeatherException, IOException {

        // Initialize the helpers and page objects
        Helpers helpers = new Helpers(driver);
        Page_GoogleSearch page_googleSearch = new Page_GoogleSearch(driver);

        // Search for the weather for the given city on Google search
        WebElement searchInput = page_googleSearch.getSearchInput();
        helpers.sendText(searchInput, "Weather in " + weatherCity);
        helpers.Click(page_googleSearch.getSearchButton());

        // Get the temperature from the Google search results page
        Temperature cityTemperature =
                new Temperature(
                        Float.parseFloat(
                                helpers.waitUntilElementToBeVisible(page_googleSearch.getWeatherTemperature()).getText()
                        )
                );

        // Get the weather for the given city from OpenWeatherMap API
        Weather cityWeather = new Weather(weatherCity, apiKey);

        // Print the city and its temperature
        System.out.println("City: " + cityWeather.getCity());
        System.out.println("Temperature: " + cityWeather.getTemperatureCelsius());

        // Round the temperature to the nearest integer
        float temperatureCelsius = cityWeather.getTemperatureCelsius();
        int roundedTemperature = Math.round(temperatureCelsius);

        // Assert that the city returned from Google search matches the expected city
        Assert.assertEquals(cityWeather.getCity(), weatherCity);

        // Assert that the temperature returned from Google search matches the temperature from OpenWeatherMap API
        Assert.assertEquals(
                roundedTemperature,
                cityTemperature.getTemperature(),
                1, // Delta for rounding error
                "The temperature from Google doesn't match the one from OpenWeatherMap"
        );
    }

}


