package ru.shanin.yandexweather23.api.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIServiceYandexWeather {
    @GET("/v2/informers")
    @Headers("X-Yandex-API-Key:f0dc601e-4859-4f00-b48b-a1c96179447a")
    Call<String> getDataGET(
            @Query("lat") double lat,
            @Query("lon") double lon);
}
