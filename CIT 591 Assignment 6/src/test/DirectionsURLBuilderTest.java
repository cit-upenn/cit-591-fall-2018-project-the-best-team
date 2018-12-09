package test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

import directions.DirectionsURLBuilder;

class DirectionsURLBuilderTest {

	DirectionsURLBuilder builder;
	@Test
	void URLtest() throws MalformedURLException {
		URL temp = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=chicago&"
				+ "destination=madison&mode=driving&departure_time=now&key=AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34");
		DirectionsURLBuilder.urlBuilder("chicago", "madison", "driving");
		assertEquals(temp, DirectionsURLBuilder.urlBuilder("chicago", "madison", "driving"));
	}

}
