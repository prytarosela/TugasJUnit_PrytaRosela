package com.example.kpltugas1;

/**
 * Service class to fetch weather data
 * In a real app, this would make API calls to a weather service
 * For this example, it provides mock data for demonstration
 */
public class WeatherService {

    /**
     * Gets weather data for a given city
     *
     * @param cityName Name of the city
     * @return WeatherData object containing weather information
     * @throws IllegalArgumentException if city name is invalid or not found
     */
    public WeatherData getWeatherData(String cityName) {
        // Check if city name is valid
        if (cityName == null || cityName.trim().isEmpty()) {
            throw new IllegalArgumentException("City name cannot be empty");
        }

        // For demonstration purposes, return mock data based on city name
        // In a real app, this would make API calls to a weather service
        switch (cityName.toLowerCase()) {
            case "jakarta":
                return new WeatherData("Jakarta", 32.5f, "Sunny", 65, 12.3f);
            case "bandung":
                return new WeatherData("Bandung", 24.8f, "Cloudy", 75, 8.5f);
            case "surabaya":
                return new WeatherData("Surabaya", 33.1f, "Clear", 60, 14.2f);
            case "yogyakarta":
                return new WeatherData("Yogyakarta", 27.6f, "Rainy", 85, 6.8f);
            case "bali":
                return new WeatherData("Bali", 29.3f, "Partly Cloudy", 70, 10.5f);
            default:
                throw new IllegalArgumentException("City not found in our database");
        }
    }

    /**
     * Validates if the given city name exists in the database
     *
     * @param cityName Name of the city to validate
     * @return true if city exists, false otherwise
     */
    public boolean isValidCity(String cityName) {
        if (cityName == null || cityName.trim().isEmpty()) {
            return false;
        }

        String city = cityName.toLowerCase();
        return city.equals("jakarta") ||
                city.equals("bandung") ||
                city.equals("surabaya") ||
                city.equals("yogyakarta") ||
                city.equals("bali");
    }
}
