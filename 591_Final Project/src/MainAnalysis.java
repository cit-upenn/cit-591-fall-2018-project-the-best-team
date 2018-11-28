import java.io.IOException;

import org.json.JSONException;

public class MainAnalysis {
	public static void main(String[] args) throws JSONException {
	
		// flight status api 
		String airportCode = "JFK";
		String typeFlight = "departure";
		String flightICAO = "KLM5518";
		FlightStatusAPI test = new FlightStatusAPI();

		try {
			System.out.println(test.makeAPICall(airportCode, typeFlight, flightICAO));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		// pre-check api 
		AirportPreCheck pre = new AirportPreCheck();
		String desiredAirport = "Chicago";
		String APIAddress = "https://www.tsa.gov/data/apcp.xml";
		try {
			System.out.println(pre.makeAPICall(desiredAirport, APIAddress));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// weather api 
		WeatherAPI weather = new WeatherAPI();
		String desiredCity = "New York";
		String keyWeather = "b19e295b4bbeda7931adb202d826296d";
		
		try {
			System.out.println(weather.makeAPICallCurrentWeather(desiredCity, keyWeather));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
