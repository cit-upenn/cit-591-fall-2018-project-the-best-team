package flightAPI;
import java.io.IOException;

import org.json.JSONException;

import weather.WeatherAPI;

public class MainAnalysis {
	public static void main(String[] args) throws JSONException {
	
		// flight status api 
		String airportCode = "JFK";
		String typeFlight = "departure";
		String flightICAO = "ASA4285";

		try {
			System.out.println(FlightStatusAPI.makeAPICall(airportCode, typeFlight, flightICAO));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		// pre-check api 
		String desiredAirport = "Chicago";
		String APIAddress = "https://www.tsa.gov/data/apcp.xml";
		try {
			System.out.println(AirportPreCheck.makeAPICall(desiredAirport, APIAddress));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// weather api 
		String desiredCity = "New York";
		String keyWeather = "b19e295b4bbeda7931adb202d826296d";
		
		try {
			System.out.println(WeatherAPI.makeAPICallCurrentWeather(desiredCity, keyWeather));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
