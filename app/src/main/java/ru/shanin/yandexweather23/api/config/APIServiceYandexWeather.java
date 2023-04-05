package ru.shanin.yandexweather23.api.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIServiceYandexWeather {
    @GET("/v2/informers")
    Call<String> getGetCityWeather_v1(
            @Header("X-Yandex-API-Key") String API_KEY,
            @Query("lat") double lat,
            @Query("lon") double lon);

    @GET("/v2/informers")
    @Headers("X-Yandex-API-Key:" + APIConfigYandexWeather.KEY)
    Call<String> getGetCityWeather_v2(
            @Query("lat") double lat,
            @Query("lon") double lon);
}
