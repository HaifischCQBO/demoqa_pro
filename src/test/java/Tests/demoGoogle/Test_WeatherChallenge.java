package Tests.demoGoogle;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Objects.Temperature;
import Objects.Weather;
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

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test_WeatherChallenge extends BaseClass {


    @Test
    @Parameters({"weatherCity", "apiKey"})
    public void exampleTest(String weatherCity, String apiKey) throws IOException {

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

        Weather illapelWeather = new Weather(apiKey, weatherCity);

        // Print temperature information
        System.out.println("Temperature: " + illapelWeather.getMain().getTemp());
        System.out.println("Feels like: " + illapelWeather.getMain().getFeelsLike());
        System.out.println("Min temperature: " + illapelWeather.getMain().getTempMin());
        System.out.println("Max temperature: " + illapelWeather.getMain().getTempMax());
    }

   /* public String weatherAPICall(String API_KEY, String weatherCity) {
        try {
            String apiUrl = String.format(API_URL, weatherCity, API_KEY);
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }*/
}


