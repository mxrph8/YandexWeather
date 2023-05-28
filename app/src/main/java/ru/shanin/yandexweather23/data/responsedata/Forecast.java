package ru.shanin.yandexweather23.data.responsedata;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {

    @SerializedName("date")
    @Expose
    public String date;
    @SerializedName("date_ts")
    @Expose
    public int dateTs;
    @SerializedName("week")
    @Expose
    public int week;
    @SerializedName("sunrise")
    @Expose
    public String sunrise;
    @SerializedName("sunset")
    @Expose
    public String sunset;
    @SerializedName("moon_code")
    @Expose
    public int moonCode;
    @SerializedName("moon_text")
    @Expose
    public String moonText;
    @SerializedName("parts")
    @Expose
    public List<Part> parts;

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }

    public String getDate() {
        return date;
    }

    public int getDateTs() {
        return dateTs;
    }

    public int getWeek() {
        return week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public int getMoonCode() {
        return moonCode;
    }

    public String getMoonText() {
        return moonText;
    }

    public List<Part> getParts() {
        return parts;
    }
}