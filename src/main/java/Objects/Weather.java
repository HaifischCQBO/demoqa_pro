package Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

class Coord {
    @JsonProperty("lon")
    public float longitude;
    @JsonProperty("lat")
    public float latitude;
}

class Main {
    public float temp;
    @JsonProperty("feels_like")
    public float feelsLike;
    @JsonProperty("temp_min")
    public float tempMin;
    @JsonProperty("temp_max")
    public float tempMax;
    public int pressure;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public int getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(int groundLevel) {
        this.groundLevel = groundLevel;
    }

    public int humidity;
    @JsonProperty("sea_level")
    public int seaLevel;
    @JsonProperty("grnd_level")
    public int groundLevel;
}

class Wind {
    public float speed;
    public int deg;
    public float gust;
}

class Clouds {
    public int all;
}

class Sys {
    public String country;
    public long sunrise;
    public long sunset;
}

class WeatherData {
    public int id;
    public String main;
    public String description;
    public String icon;
}
public class Weather {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s";
    private Coord coord;
    private List<WeatherData> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public Weather(String apiKey, String weatherCity) {
        Weather weather = weatherAPICall(apiKey, weatherCity);
        this.coord = weather.getCoord();
        this.weather = weather.getWeather();
        this.base = weather.getBase();
        this.main = weather.getMain();
        this.visibility = weather.getVisibility();
        this.wind = weather.getWind();
        this.clouds = weather.getClouds();
        this.dt = weather.getDt();
        this.sys = weather.getSys();
        this.timezone = weather.getTimezone();
        this.id = weather.getId();
        this.name = weather.getName();
        this.cod = weather.getCod();
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<WeatherData> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherData> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    private Weather parseJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Weather weather = objectMapper.readValue(json, Weather.class);
            return weather;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Weather weatherAPICall(String API_KEY, String weatherCity) {
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

            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather = objectMapper.readValue(response.toString(), Weather.class);
            return weather;
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}