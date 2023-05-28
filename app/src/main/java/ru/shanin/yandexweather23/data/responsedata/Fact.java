package ru.shanin.yandexweather23.data.responsedata;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fact {

    @SerializedName("obs_time")
    @Expose
    public int obsTime;
    @SerializedName("temp")
    @Expose
    public int temp;
    @SerializedName("feels_like")
    @Expose
    public int feelsLike;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("condition")
    @Expose
    public String condition;
    @SerializedName("wind_speed")
    @Expose
    public double windSpeed;
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
    @SerializedName("daytime")
    @Expose
    public String daytime;
    @SerializedName("polar")
    @Expose
    public boolean polar;
    @SerializedName("season")
    @Expose
    public String season;
    @SerializedName("wind_gust")
    @Expose
    public double windGust;

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }


    public int getObsTime() {
        return obsTime;
    }

    public int getTemp() {
        return temp;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getWindDir() {
        return windDir;
    }

    public int getPressureMm() {
        return pressureMm;
    }

    public int getPressurePa() {
        return pressurePa;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDaytime() {
        return daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public String getSeason() {
        return season;
    }

    public double getWindGust() {
        return windGust;
    }
}
