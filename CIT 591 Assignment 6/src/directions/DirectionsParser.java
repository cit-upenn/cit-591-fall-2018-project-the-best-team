package directions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * parse directions object
 * @author shengfeng
 *
 */
public class DirectionsParser {
	public static DirectionsObject setJsonDirections (URL directions) throws IOException, JSONException {
		URLConnection yc=directions.openConnection();
		BufferedReader in=new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String jsonText="";
		while ((inputLine=in.readLine())!=null) {
			jsonText+=inputLine;
		}
		in.close();
		JSONObject jObj = new JSONObject(jsonText);
		JSONArray routes;
		routes=jObj.getJSONArray("routes");
		JSONObject routes0;
		routes0=routes.getJSONObject(0);
		JSONArray legs;
		legs=routes0.getJSONArray("legs");
		JSONObject legs0;
		legs0=legs.getJSONObject(0);
		
		DirectionsObject d=new DirectionsObject();
		d.setDestination(legs0.getString("end_address"));
		d.setOrigin(legs0.getString("start_address"));
		d.setDuration(((JSONObject)legs0.get("duration")).getString("text"));
		d.setDistance(((JSONObject)legs0.get("distance")).getString("text"));
		return d;
	}
}
