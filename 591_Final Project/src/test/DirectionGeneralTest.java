package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import directions.DirectionsObject;
import directions.DirectionsParser;
import directions.DirectionsURLBuilder;
import directions.tester;

class DirectionGeneralTest {
	
	URL temp;
	DirectionsObject object;
	public DirectionGeneralTest() throws MalformedURLException {
		temp = DirectionsURLBuilder.urlBuilder("chicago", "madison", "walking");		
	}
	
	
	@Test
	void DirectionOrigintest() throws IOException, JSONException {
		object = DirectionsParser.setJsonDirections(temp);
		assertEquals("Chicago, IL, USA", object.getOrigin());
	}
	
	@Test
	void DirectionDestest() throws IOException, JSONException {
		object = DirectionsParser.setJsonDirections(temp);		
		assertEquals("Madison, WI, USA", object.getDestination());
	}
	
	@Test
	void DirectionDistancetest() throws IOException, JSONException {
		object = DirectionsParser.setJsonDirections(temp);		
		assertEquals("138 mi", object.getDistance());
	}

	@Test
	void DirectionTimetest() throws IOException, JSONException {
		object = DirectionsParser.setJsonDirections(temp);
		assertEquals("1 day 22 hours", object.getDuration());
	}
}
