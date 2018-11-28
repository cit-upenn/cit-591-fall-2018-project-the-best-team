import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.jar.JarException;

import javax.swing.JScrollBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FlightStatusAPI {
	
	
	public String makeAPICall(String airportCode, String typeFlight, String flightICAO) throws IOException, JSONException {
		
		String url = "http://aviation-edge.com/v2/public/timetable?key=";
		String keyStatus = "82aebf-0173d3";
		String argument = "&iataCode=";
		String airport = airportCode;
		String argument1 = "&type=";
		String type = typeFlight;
		String urlKey = url + keyStatus + argument + airport + argument1 + type; 


		URL flightStatus;
		URLConnection yc;
		BufferedReader in;
		String resRaw; 
		
		flightStatus = new URL(urlKey);
		yc = flightStatus.openConnection();
		in = new BufferedReader(new InputStreamReader(
                 yc.getInputStream()));
		String inputLine;
		
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
		     response.append(inputLine);
		}
		in.close();
		     
		resRaw = "{schedule:" + response.toString() + "}";

		JSONObject jObj = new JSONObject(resRaw);
		JSONArray jArray = jObj.getJSONArray("schedule");
		String res = "wrong input, plz try again";
		
		String status = "";
		String scheduledTime = "";
		String estimatedTime = "";
		String arrivalAirportIATA = "";
		String arrivalTerminal = "";
		String arrivalGate = "";
		String arrivalScheduledTime = "";
		String arrivalEstimatedTime = "";
		String airLine = "";
		String flight = "";
		
		for(int i=0;i<jArray.length();i++) {
			// don't include code shared condition 
			if(jArray.getJSONObject(i).getJSONObject("flight").getString("icaoNumber").equals(flightICAO)) {
				status = jArray.getJSONObject(i).getString("status");
				scheduledTime = jArray.getJSONObject(i).getJSONObject("departure").getString("scheduledTime");
				
				if(status.equals("cancelled") || status.equals("unkonwn") || status.equals("incident") ) {
					estimatedTime = "N/A";
					arrivalAirportIATA =  "N/A";
					arrivalTerminal =  "N/A";
					arrivalGate =  "N/A";
					arrivalScheduledTime =  "N/A";
					arrivalEstimatedTime =  "N/A";
					airLine =  "N/A";
				}
				else {
					estimatedTime = jArray.getJSONObject(i).getJSONObject("departure").getString("estimatedTime");
					arrivalAirportIATA = jArray.getJSONObject(i).getJSONObject("arrival").getString("iataCode");
					//arrivalTerminal = jArray.getJSONObject(i).getJSONObject("arrival").getString("terminal");
					//arrivalGate = jArray.getJSONObject(i).getJSONObject("arrival").getString("gate");
					arrivalScheduledTime = jArray.getJSONObject(i).getJSONObject("arrival").getString("scheduledTime");
					arrivalEstimatedTime = jArray.getJSONObject(i).getJSONObject("arrival").getString("estimatedTime");
					airLine = jArray.getJSONObject(i).getJSONObject("airline").getString("name");
				}
				
			}
		}
		
	
		res = "Status: " + status + " scheduledTime: " + scheduledTime + " estimatedTime: " + estimatedTime + " arrivalAirportIATA: "
				+ arrivalAirportIATA + " arrivalScheduledTime: " + arrivalScheduledTime + " arrivalEstimatedTime: " + arrivalEstimatedTime  
				+ " airLine: "+ airLine;
		
		return res;
		
	}
	

	
}