package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import geocoding.GeocodingObject;
import geocoding.GeocodingParser;
import geocoding.GeocodingURLBuilder;

class geoCodingGeneralTest {

	GeocodingObject object;
	URL temp;
	
	public geoCodingGeneralTest() throws MalformedURLException {
		temp = GeocodingURLBuilder.urlBuilder("chicago");
	}
	
	
	@Test
	void lonTest() throws IOException, JSONException {
		object = GeocodingParser.setLonLat(temp);
		assertEquals(-87.6297982, object.getLon());
	}
	
	@Test
	void latTest() throws IOException, JSONException {
		object = GeocodingParser.setLonLat(temp);
		assertEquals(41.8781136, object.getLat());
	}


}
