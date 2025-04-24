package com.example.kpltugas1;

import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherServiceTest {

    private WeatherService weatherService = new WeatherService();

    /**
     * Test case 1: Verifikasi data cuaca untuk kota Jakarta
     * Deskripsi: Memastikan WeatherService mengembalikan data cuaca yang benar untuk kota Jakarta
     * Input: cityName = "Jakarta"
     * Expected output: WeatherData object dengan nilai yang sesuai untuk Jakarta
     */
    @Test
    public void getWeatherData_forJakarta_returnsCorrectData() {
        String cityName = "Jakarta";

        WeatherData weatherData = weatherService.getWeatherData(cityName);

        assertEquals("Jakarta", weatherData.getCityName());
        assertEquals(32.5f, weatherData.getTemperature(), 0.01);
        assertEquals("Sunny", weatherData.getCondition());
        assertEquals(65, weatherData.getHumidity());
        assertEquals(12.3f, weatherData.getWindSpeed(), 0.01);
    }

    /**
     * Test case 2: Verifikasi penanganan kota yang tidak ditemukan
     * Deskripsi: Memastikan WeatherService melempar IllegalArgumentException saat kota tidak ada di database
     * Input: cityName = "London"
     * Expected output: IllegalArgumentException dengan pesan yang sesuai
     */
    @Test(expected = IllegalArgumentException.class)
    public void getWeatherData_forNonExistentCity_throwsException() {
        String cityName = "London";

        weatherService.getWeatherData(cityName);
    }

    /**
     * Test case 3: Verifikasi validasi kota yang valid
     * Deskripsi: Memastikan metode isValidCity() mengembalikan true untuk kota yang ada di database
     * Input: cityName = "Bandung"
     * Expected output: true
     */
    @Test
    public void isValidCity_forExistingCity_returnsTrue() {
        String cityName = "Bandung";

        boolean isValid = weatherService.isValidCity(cityName);

        assertTrue(isValid);
    }

    /**
     * Test case 4: Verifikasi validasi kota yang tidak valid
     * Deskripsi: Memastikan metode isValidCity() mengembalikan false untuk kota yang tidak ada di database
     * Input: cityName = "Paris"
     * Expected output: false
     */
    @Test
    public void isValidCity_forNonExistentCity_returnsFalse() {
        String cityName = "Paris";

        boolean isValid = weatherService.isValidCity(cityName);

        assertFalse(isValid);
    }
}