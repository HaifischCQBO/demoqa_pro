package Objects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Weather {
    private String city;
    private float temperatureCelsius;
    private double humidity;

    public Weather(String city, String appid) throws WeatherException, IOException {
        // Call the weather API and get the JSON response as a JSONObject
        JSONObject json = callWeatherApi(city, appid);

        // Set the city property of the Weather object
        this.city = city;

        // Get the temperature in Kelvin from the JSON response and convert it to Celsius
        double temperatureKelvin = json.getJSONObject("main").getDouble("temp");
        this.temperatureCelsius = (float) (temperatureKelvin - 273.15); // Convert from Kelvin to Celsius

        // Get the humidity from the JSON response and set it as the humidity property of the Weather object
        this.humidity = json.getJSONObject("main").getDouble("humidity");
    }

    private JSONObject callWeatherApi(String city, String appid) throws WeatherException {
        // Construct the API URL using the city and appid parameters
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + appid;

        try {
            // Make an HTTP request to the API URL and get the JSON response as a string
            String jsonString = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));

            // Parse the JSON response string into a JSONObject
            JSONObject json = new JSONObject(jsonString);

            // Return the JSONObject
            return json;
        } catch (IOException | JSONException e) {
            // Throw a WeatherException if there was an error making the API call
            throw new WeatherException("Failed to call weather API: " + e.getMessage() + " URL: " + url, e);
        }
    }

    // Getter method for city name
    public String getCity() {
        return city;
    }

    // Getter method for temperature in Celsius
    public float getTemperatureCelsius() {
        return temperatureCelsius;
    }

    // Getter method for humidity
    public double getHumidity() {
        return humidity;
    }

    // Custom exception class for handling errors related to weather API calls
    public static class WeatherException extends Exception {
        public WeatherException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
