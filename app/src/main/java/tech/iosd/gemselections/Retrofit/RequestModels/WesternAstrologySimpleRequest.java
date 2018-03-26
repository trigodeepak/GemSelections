package tech.iosd.gemselections.Retrofit.RequestModels;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class WesternAstrologySimpleRequest {
    int day;

    int month;

    int year;

    int hour;

    int min;

    float lat;

    float lon;

    float tzone;

    public WesternAstrologySimpleRequest(int day, int month, int year, int hour, int min, float lat, float lon, float tzone) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.lat = lat;
        this.lon = lon;
        this.tzone = tzone;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getTzone() {
        return tzone;
    }

    public void setTzone(float tzone) {
        this.tzone = tzone;
    }
}
