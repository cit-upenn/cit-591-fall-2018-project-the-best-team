package geocoding;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;


/**
 * this class tests the functionality of the APIs
 * @author zhenyan
 *
 */
public class tester {
	public static void main(String[] args) throws IOException, JSONException {
		System.out.println("please type address");
		Scanner scan=new Scanner(System.in);
		String address=scan.nextLine();
		scan.close();
		URL url=GeocodingURLBuilder.urlBuilder(address);
		System.out.println(url);
		GeocodingObject d=GeocodingParser.setLonLat(url);
		System.out.println(d.getLon());
		System.out.println(d.getLat());

	}
	
}
