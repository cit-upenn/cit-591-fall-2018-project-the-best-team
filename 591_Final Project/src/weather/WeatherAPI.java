package weather;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherAPI {
	public static String makeAPICallCurrentWeather(String city, String key) throws IOException, JSONException {
		// can also change to city ID and ZIP 
		String urlInit = "https://api.openweathermap.org/data/2.5/weather?q=";
		String url = urlInit + city + "&APPID=" + key;
		
		URL weatherCon;
		URLConnection yc;
		BufferedReader in;
		weatherCon = new URL(url);
		yc = weatherCon.openConnection();
		in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		String res = "find nothing";
		String description = "";
		double temp = 0;
		double humidity = 0;
		int pressure = 0;
		
		while ((inputLine = in.readLine()) != null) {
		     response.append(inputLine);
		}
		in.close();
  
		String APIRes = response.toString();
		
		// an example of json, not used here 

		JSONObject jObj = new JSONObject(APIRes);
		JSONArray jArray = jObj.getJSONArray("weather");

		
		for(int i=0;i<jArray.length();i++) {
			description = jArray.getJSONObject(i).getString("description");
		}
		
		JSONObject jObj1 = (JSONObject) jObj.get("main");
		
		temp = jObj1.getDouble("temp");
		temp = 1.8 * (temp-273) + 32;
		temp = Math.round(temp);
		humidity = jObj1.getDouble("humidity");
		pressure = jObj1.getInt("pressure");
		
		
		res = "<br/>Weather: " + description + "<br/>Temperature: " + temp + " F"+ "<br/>Humidity: " +humidity + "%" + "<br/>Pressure: " +pressure+"<br/>";
		
		return res;
	}
}
