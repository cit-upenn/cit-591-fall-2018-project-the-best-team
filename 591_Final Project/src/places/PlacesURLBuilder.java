package places;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;

import geocoding.GeocodingParser;
import geocoding.GeocodingURLBuilder;
import geocoding.GeocodingObject;
/**
 * build url to make api call
 * @author shengfeng
 *
 */
public class PlacesURLBuilder {
	public static URL urlBuilder(String address,String type,double radius) throws IOException, JSONException {
		String key="AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34";
		address=address.replaceAll(" ", "+");
		GeocodingObject l=GeocodingParser.setLonLat(GeocodingURLBuilder.urlBuilder(address));
		double lat=l.getLat();
		double lon=l.getLon();
		radius=radius*3.28084; //meter to ft
		URL url=new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
			+lat+","+lon+"&radius="
					+radius+"&type="
					+ type+"&opennow=true"+
					"&key="+key);
		return url;
	}
}
