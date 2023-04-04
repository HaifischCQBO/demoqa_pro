package Tests.demoGoogle;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Objects.Temperature;
import Pages.Page_GoogleSearch;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Test_WeatherChallenge extends BaseClass {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/onecall?lat=%s&lon=%s&appid=%s";

    @Test
    @Parameters({"weatherCity", "apiKey"})
    public void exampleTest(String weatherCity, String apiKey) {

        Helpers helpers = new Helpers(driver);
        Page_GoogleSearch page_googleSearch = new Page_GoogleSearch(driver);
        WebElement searchInput = page_googleSearch.getSearchInput();
        helpers.sendText(searchInput, "Weather in " + weatherCity);
        helpers.Click(page_googleSearch.getSearchButton());
        Temperature illapelTemperature =
                new Temperature(
                        Float.parseFloat(
                                helpers.waitUntilElementToBeVisible(page_googleSearch.getWeatherTemperature()
                                ).getText()

                        )
                );

        System.out.println(illapelTemperature.getTemperature());
        weatherAPICall(apiKey);
    }

    public void weatherAPICall(String API_KEY) {
        try {
            // Example location (New York City)
            double lat = -31.63349;
            double lon = -71.16967;

            String apiUrl = String.format(API_URL, lat, lon, API_KEY);
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response from the API endpoint
            System.out.println(response.toString());

        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
