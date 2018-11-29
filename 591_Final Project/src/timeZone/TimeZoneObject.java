package timeZone;

public class TimeZoneObject {
	long dstOffset;
	long rawOffset;
	String timeZoneName;
	String localTime;
	public long getDstOffset() {
		return dstOffset;
	}
	public void setDstOffset(long dstOffset) {
		this.dstOffset = dstOffset;
	}
	public long getRawOffset() {
		return rawOffset;
	}
	public void setRawOffset(long rawOffset) {
		this.rawOffset = rawOffset;
	}
	public String getTimeZoneName() {
		return timeZoneName;
	}
	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}
	public String getLocalTime() {
		return localTime;
	}
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
}
