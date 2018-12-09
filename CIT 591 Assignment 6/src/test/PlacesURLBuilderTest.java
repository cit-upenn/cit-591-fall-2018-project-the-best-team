package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URL;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import places.PlacesURLBuilder;

class PlacesURLBuilderTest {

	@Test
	void URLtest() throws IOException, JSONException {
		URL temp = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=29.8301319,-98.77167639999999"
				+ "&radius=328.084&type=driving&opennow=true&key=AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34");
		assertEquals(PlacesURLBuilder.urlBuilder("random", "driving", 100), temp);
	}

}
