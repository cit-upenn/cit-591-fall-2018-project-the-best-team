package timeZone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import geocoding.LonLatObject;

public class TimeZoneParser {
	public static TimeZoneObject setTimeZone (URL url) throws IOException, JSONException {
		URLConnection yc=url.openConnection();
		BufferedReader in=new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		String jsonText="";
		while ((inputLine=in.readLine())!=null) {
			jsonText
			+=inputLine;
		}
		in.close();
		JSONObject jObj = new JSONObject(jsonText);
		TimeZoneObject t=new TimeZoneObject();
		t.setDstOffset(jObj.getLong("dstOffset"));
		t.setRawOffset(jObj.getLong("rawOffset"));
		t.setTimeZoneName(jObj.getString("timeZoneName"));
		long timeInUTC=Instant.now().toEpochMilli()+1000*(t.getDstOffset()+t.getRawOffset());
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		Timestamp ts=new Timestamp(timeInUTC);
		t.setLocalTime(ts.toString().substring(0, ts.toString().length()-4));
		return t;
	}
}
