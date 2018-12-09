package timeZone;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;

import org.json.JSONException;

import geocoding.GeocodingParser;
import geocoding.GeocodingURLBuilder;
import geocoding.GeocodingObject;
/**
 * build url to make api call
 * @author shengfeng
 *
 */
public class TimeZoneURLBuilder {
	public static URL urlBuilder(String address) throws IOException, JSONException {
		String key="AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34";
		address=address.replaceAll(" ", "+");
		GeocodingObject l=GeocodingParser.setLonLat(GeocodingURLBuilder.urlBuilder(address));
		double lat=l.getLat();
		double lon=l.getLon();
		Long timeStamp=Instant.now().getEpochSecond();
		URL url=new URL("https://maps.googleapis.com/maps/api/timezone/json?location="
				+ lat+","+lon+"&timestamp="
						+ timeStamp+"&key="+key);

		return url;
	}
}
