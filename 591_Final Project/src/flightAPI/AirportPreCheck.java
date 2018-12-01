package flightAPI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class AirportPreCheck {
	public static String makeAPICall(String airport, String url) throws IOException {
		URL preCheck;
		URLConnection yc;
		BufferedReader in;
		preCheck = new URL(url);
		yc = preCheck.openConnection();
		in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		String res = "find nothing";

		while ((inputLine = in.readLine()) != null) {
		     response.append(inputLine);
		}
		in.close();
		     
		String APIRes = response.toString();
		
		String[] airports = APIRes.split("</airport>");
		for(String i: airports) {
			if(i.contains(airport)) {
				String[] findPre = i.split("<precheck>");
				res = findPre[1].substring(0, 5);
				res = res.replaceAll("[^A-Za-z0-9]", "");
				break;
			}
		}
		
		return "Precheck required: "+res;
	
	}
}
