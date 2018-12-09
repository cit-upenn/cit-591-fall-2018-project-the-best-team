package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import weather.WeatherAPI;

class weatherAPIGeneralURLTest {
	
	
	
	@Test
	void URLtest() {
		String temp = "https://api.openweathermap.org/data/2.5/weather?q=chicago&APPID=b19e295b4bbeda7931adb202d826296d";
		assertEquals(temp, WeatherAPI.getURL("chicago", "b19e295b4bbeda7931adb202d826296d"));
	}
	
	// weather result varies 
	@Test
	void Restest() throws IOException, JSONException {	
		String res = "<br/>Weather: clear sky<br/>Temperature: 30.0 F<br/>Humidity: 61.0%<br/>Pressure: 1020<br/>\r\n";
		assertEquals(true, WeatherAPI.makeAPICallCurrentWeather("New York", "b19e295b4bbeda7931adb202d826296d").contains("Weather:") &&
				WeatherAPI.makeAPICallCurrentWeather("New York", "b19e295b4bbeda7931adb202d826296d").contains("Temperature:") &&
				WeatherAPI.makeAPICallCurrentWeather("New York", "b19e295b4bbeda7931adb202d826296d").contains("Humidity:") &&
				WeatherAPI.makeAPICallCurrentWeather("New York", "b19e295b4bbeda7931adb202d826296d").contains("Pressure:"));
	}

}
