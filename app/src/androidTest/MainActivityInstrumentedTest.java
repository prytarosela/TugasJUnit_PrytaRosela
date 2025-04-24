package com.example.kpltugas1;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    /**
     * Test case 1: Verifikasi tampilan prakiraan cuaca untuk kota valid
     * Deskripsi: Memastikan aplikasi menampilkan informasi cuaca yang benar
     * ketika pengguna memasukkan nama kota yang valid dan menekan tombol Search
     * Input: cityName = "Jakarta"
     * Expected output: TextView menampilkan informasi cuaca untuk Jakarta
     */
    @Test
    public void searchWeather_withValidCity_displaysWeatherInfo() {
        // Memulai aktivitas MainActivity
        ActivityScenario.launch(MainActivity.class);

        // Input nama kota
        onView(withId(R.id.cityEditText)).perform(typeText("Jakarta"), closeSoftKeyboard());

        // Klik tombol search
        onView(withId(R.id.searchButton)).perform(click());

        // Verifikasi hasil cuaca yang ditampilkan
        onView(withId(R.id.weatherResultTextView)).check(matches(withText(containsString("City: Jakarta"))));
        onView(withId(R.id.weatherResultTextView)).check(matches(withText(containsString("Temperature: 32.5°C"))));
        onView(withId(R.id.weatherResultTextView)).check(matches(withText(containsString("Condition: Sunny"))));
    }

    /**
     * Test case 2: Verifikasi pesan error untuk kota tidak valid
     * Deskripsi: Memastikan aplikasi menghapus hasil sebelumnya ketika user
     * memasukkan kota yang tidak ada dalam database
     * Input: cityName = "London"
     * Expected output: TextView hasil harus kosong
     */
    @Test
    public void searchWeather_withInvalidCity_clearsResultView() {
        // Memulai aktivitas MainActivity
        ActivityScenario.launch(MainActivity.class);

        // Masukkan kota valid terlebih dahulu untuk mendapatkan hasil
        onView(withId(R.id.cityEditText)).perform(typeText("Jakarta"), closeSoftKeyboard());
        onView(withId(R.id.searchButton)).perform(click());

        // Verifikasi ada hasil tampil
        onView(withId(R.id.weatherResultTextView)).check(matches(withText(containsString("Jakarta"))));

        // Masukkan kota tidak valid
        onView(withId(R.id.cityEditText)).perform(typeText("London"), closeSoftKeyboard());
        onView(withId(R.id.searchButton)).perform(click());

        // Verifikasi bahwa result text view sudah dikosongkan
        onView(withId(R.id.weatherResultTextView)).check(matches(withText("")));
    }
}