package directions;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * build url to make api call
 * @author shengfeng
 *
 */
public class DirectionsURLBuilder {
	public static URL urlBuilder(String origin,String destination,String mode) throws MalformedURLException {
		String key="AIzaSyCJg8XbSpe7nWqvgOJEOLANj2Nut2tY_34";
		origin=origin.replaceAll(" ", "_");
		destination=destination.replaceAll(" ", "+");
		mode=mode.replaceAll(" ", "_");
		URL googleDirection=new URL("https://maps.googleapis.com/maps/api/directions/json?origin="
				+ origin
				+"&destination="
				+ destination
				+"&mode="
				+mode
				+"&departure_time=now&key="+key);
		return googleDirection;
	}
}
