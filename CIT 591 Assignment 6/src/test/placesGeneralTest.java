package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import places.PlacesObject;
import places.PlacesParser;
import places.PlacesURLBuilder;

class placesGeneralTest {
	
	URL temp;
	ArrayList<PlacesObject> object;
	
	public placesGeneralTest() throws IOException, JSONException {
		temp = PlacesURLBuilder.urlBuilder("madison", "restaurant", 50);
	}
	
	@Test
	void nameTest() throws IOException, JSONException {
		ArrayList<PlacesObject> object = PlacesParser.setPlaces(temp);
		assertEquals("Rheta's Market", object.get(0).getName());
	}
	
	@Test
	void addressTest() throws IOException, JSONException {
		ArrayList<PlacesObject> object = PlacesParser.setPlaces(temp);
		assertEquals("Barnard Hall, 970 University Avenue, Madison", object.get(0).getAddress());
	}

	@Test
	void rateTest() throws IOException, JSONException {
		ArrayList<PlacesObject> object = PlacesParser.setPlaces(temp);
		assertEquals(3.5, object.get(0).getRating());
	}
}
