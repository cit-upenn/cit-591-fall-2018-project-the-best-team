package geocoding;
/**
 * this class implements GeocodingObject 
 * @author zhenyan
 *
 */
public class GeocodingObject {
	double lon;
	double lat;
	GeocodingObject(double lon,double lat){
		this.lon=lon;
		this.lat=lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
}
