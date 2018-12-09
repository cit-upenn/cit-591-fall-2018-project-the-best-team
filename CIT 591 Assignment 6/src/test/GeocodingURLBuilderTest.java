package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geocoding.GeocodingURLBuilder;

class GeocodingURLBuilderTest {

	GeocodingURLBuilder builder;
	
	@Test
	void ReplaceAlltest() {
		GeocodingURLBuilder.refineAdd("Chicago Museum Madison Street");
		assertEquals("Chicago+Museum+Madison+Street", GeocodingURLBuilder.refineAdd("Chicago Museum Madison Street"));
	}
	
	

}
