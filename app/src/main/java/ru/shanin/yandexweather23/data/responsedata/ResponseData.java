package ru.shanin.yandexweather23.data.responsedata;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData {

    @SerializedName("now")
    @Expose
    public int now;
    @SerializedName("now_dt")
    @Expose
    public String nowDt;
    @SerializedName("info")
    @Expose
    public Info info;
    @SerializedName("fact")
    @Expose
    public Fact fact;
    @SerializedName("forecast")
    @Expose
    public Forecast forecast;

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }

    public int getNow() {
        return now;
    }

    public String getNowDt() {
        return nowDt;
    }

    public Info getInfo() {
        return info;
    }

    public Fact getFact() {
        return fact;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
