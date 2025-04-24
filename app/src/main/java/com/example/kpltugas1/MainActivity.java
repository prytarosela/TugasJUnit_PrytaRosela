package com.example.kpltugas1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kpltugas1.R;

public class MainActivity extends AppCompatActivity {

    private EditText cityEditText;
    private Button searchButton;
    private TextView weatherResultTextView;
    private WeatherService weatherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        cityEditText = findViewById(R.id.cityEditText);
        searchButton = findViewById(R.id.searchButton);
        weatherResultTextView = findViewById(R.id.weatherResultTextView);

        // Initialize weather service
        weatherService = new WeatherService();

        // Set click listener for search button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWeather();
            }
        });
    }

    private void searchWeather() {
        // Get input values
        String cityName = cityEditText.getText().toString().trim();

        // Validate input
        if (cityName.isEmpty()) {
            Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Get weather data for the city
            WeatherData weatherData = weatherService.getWeatherData(cityName);

            // Display weather information
            String weatherInfo = String.format(
                    "City: %s\nTemperature: %.1f°C\nCondition: %s\nHumidity: %d%%\nWind: %.1f km/h",
                    weatherData.getCityName(),
                    weatherData.getTemperature(),
                    weatherData.getCondition(),
                    weatherData.getHumidity(),
                    weatherData.getWindSpeed()
            );

            weatherResultTextView.setText(weatherInfo);
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            weatherResultTextView.setText("");
        }
    }
}
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}