package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import timeZone.TimeZoneURLBuilder;

class timeZoneURLBuilderTest {

	@Test
	void test() throws IOException, JSONException {
		// time stamp changes dynamically  
		assertEquals(true, String.valueOf(TimeZoneURLBuilder.urlBuilder("chicago")).contains("https://maps.googleapis.com/maps/api/timezone"
				+ "/json?location=41.8781136,-87.6297982&timestamp="));
		assertEquals(true, String.valueOf(TimeZoneURLBuilder.urlBuilder("chicago")).contains("&key=AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34"));
	}

}
