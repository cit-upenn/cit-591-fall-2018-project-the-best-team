package geocoding;


import java.net.MalformedURLException;
import java.net.URL;
/**
 * build url to make api call
 * @author shengfeng
 *
 */
public class GeocodingURLBuilder {
	public static URL urlBuilder(String address) throws MalformedURLException {
		String key="AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34";
		address=address.replaceAll(" ", "+");
		
		URL geoCoding=new URL("https://maps.googleapis.com/maps/api/geocode/json?address="
			+address+"&key="
					+ key			
			);
		return geoCoding;
	}
}
