package timeZone;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;



public class tester {
	public static void main(String[] args) throws IOException, JSONException {
		System.out.println("please type address");
		Scanner scan=new Scanner(System.in);
		String address=scan.nextLine();
		scan.close();
		URL url=TimeZoneURLBuilder.urlBuilder(address);
		System.out.println(url);
		TimeZoneObject t=TimeZoneParser.setTimeZone(url);
		
		System.out.println(t.getLocalTime());
		System.out.println(t.getTimeZoneName());

	}
	
}
