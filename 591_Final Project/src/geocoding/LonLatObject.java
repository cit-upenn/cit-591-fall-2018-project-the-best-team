package geocoding;

public class LonLatObject {
	double lon;
	double lat;
	LonLatObject(double lon,double lat){
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
