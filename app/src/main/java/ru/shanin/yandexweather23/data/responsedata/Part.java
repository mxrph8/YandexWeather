package ru.shanin.yandexweather23.data.responsedata;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Part {

    @SerializedName("part_name")
    @Expose
    public String partName;
    @SerializedName("temp_min")
    @Expose
    public int tempMin;
    @SerializedName("temp_avg")
    @Expose
    public int tempAvg;
    @SerializedName("temp_max")
    @Expose
    public int tempMax;
    @SerializedName("wind_speed")
    @Expose
    public double windSpeed;
    @SerializedName("wind_gust")
    @Expose
    public double windGust;
    @SerializedName("wind_dir")
    @Expose
    public String windDir;
    @SerializedName("pressure_mm")
    @Expose
    public int pressureMm;
    @SerializedName("pressure_pa")
    @Expose
    public int pressurePa;
    @SerializedName("humidity")
    @Expose
    public int humidity;
    @SerializedName("prec_mm")
    @Expose
    public int precMm;
    @SerializedName("prec_prob")
    @Expose
    public int precProb;
    @SerializedName("prec_period")
    @Expose
    public int precPeriod;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("condition")
    @Expose
    public String condition;
    @SerializedName("feels_like")
    @Expose
    public int feelsLike;
    @SerializedName("daytime")
    @Expose
    public String daytime;
    @SerializedName("polar")
    @Expose
    public boolean polar;

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }
}


