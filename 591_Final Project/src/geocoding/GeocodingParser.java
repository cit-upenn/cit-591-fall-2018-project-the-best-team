package geocoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import directions.DirectionsObject;

public class GeocodingParser {
	public static LonLatObject setLonLat (URL geocodingURL) throws IOException, JSONException {
		URLConnection yc=geocodingURL.openConnection();
		BufferedReader in=new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String jsonText="";
		while ((inputLine=in.readLine())!=null) {
			jsonText+=inputLine;
		}
		in.close();
		JSONObject jObj = new JSONObject(jsonText);
		JSONArray jArray=jObj.getJSONArray("results");
		JSONObject results0;
		results0=jArray.getJSONObject(0);
		JSONObject geometry;
		geometry=results0.getJSONObject("geometry");
		
		JSONObject location;
		location=geometry.getJSONObject("location");
		double lon=location.getDouble("lng");
		double lat=location.getDouble("lat");
		LonLatObject d=new LonLatObject(lon,lat);
		return d;
	}
}
