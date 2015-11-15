package sos.com.sosserver;

/**
 * Created by SampleText on 15-11-2015.
 */
public class Ambulance {

    public String getLat() {
        return lat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    String time;

    public void setLat(String lat) {
        this.lat = lat;
    }

    String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    String lon;

    public Ambulance(){
        this.lat=null;
        this.lon=null;
    }

    public Ambulance(String lat, String lon,String time){
        this.lat=lat;
        this.lon=lon;
        this.time=time;
    }
}
