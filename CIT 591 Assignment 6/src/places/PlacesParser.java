package places;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import directions.DirectionsObject;
import directions.DirectionsParser;
import directions.DirectionsURLBuilder;
import geocoding.GeocodingObject;
/**
 * parse places object
 * @author shengfeng
 *
 */
public class PlacesParser {
	public static ArrayList<PlacesObject> setPlaces (URL url) throws IOException, JSONException {
		URLConnection yc=url.openConnection();
		BufferedReader in=new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String jsonText="";
		while ((inputLine=in.readLine())!=null) {
			jsonText+=inputLine;
		}
		in.close();
		ArrayList<PlacesObject> res=new ArrayList<>();
		JSONObject jObj = new JSONObject(jsonText);
		JSONArray jArray=jObj.getJSONArray("results");
		for (int i=0;i<jArray.length();i++) {
			PlacesObject p=new PlacesObject();
			p.setAddress(jArray.getJSONObject(i).getString("vicinity"));
			p.setName(jArray.getJSONObject(i).getString("name"));
			p.setOpenNow(jArray.getJSONObject(i).getJSONObject("opening_hours").getBoolean("open_now"));
			p.setRating(jArray.getJSONObject(i).getDouble("rating"));
		//	DirectionsObject d=DirectionsParser.
		//			setJsonDirections(DirectionsURLBuilder.urlBuilder(address, p.getAddress(), "driving"));

	//		p.setDistance(d.getDistance());
			res.add(p);
			if (i>10) {
				break;
			}
		}
		return res;
	}
}
