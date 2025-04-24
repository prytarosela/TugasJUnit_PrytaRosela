package com.example.kpltugas1;

/**
 * Model class to represent weather data for a city
 */
public class WeatherData {
    private String cityName;
    private float temperature;  // in Celsius
    private String condition;
    private int humidity;       // percentage
    private float windSpeed;    // km/h

    public WeatherData(String cityName, float temperature, String condition, int humidity, float windSpeed) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getCityName() {
        return cityName;
    }

    public float getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }
}