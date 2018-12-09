package test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import flightAPI.FlightStatusAPI;

class FlightStatusAPITest {

	FlightStatusAPI flightAPI;
	@Test
	void URLtest() throws MalformedURLException {
		String temp ="http://aviation-edge.com/v2/public/timetable?key=82aebf-0173d3&iataCode=JFK&type=departure";
		assertEquals(temp, FlightStatusAPI.getURL("JFK", "departure"));
	}

	

}
