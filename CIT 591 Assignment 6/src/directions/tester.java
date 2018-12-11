package directions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONException;
/**
 * this class tests the functionality of the APIs
 * @author zhenyan
 *
 */
public class tester {
public static void main(String[] args) throws IOException, JSONException {
	System.out.println("please type origin");
	Scanner scan=new Scanner(System.in);
	String origin=scan.nextLine();
	System.out.println("please type destination");
	String destination=scan.nextLine();
	System.out.println("please type mode");
	String mode=scan.nextLine();
	scan.close();
	
	URL googleDirection=DirectionsURLBuilder.urlBuilder(origin, destination, mode);
	System.out.println(googleDirection);
	DirectionsObject d=new DirectionsObject();
	d=DirectionsParser.setJsonDirections(googleDirection);
	System.out.println(d.getOrigin());
	System.out.println(d.getDestination());
	System.out.println(d.getDistance());
	System.out.println(d.getDuration());
	
}
}
