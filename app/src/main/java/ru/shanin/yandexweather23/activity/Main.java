package ru.shanin.yandexweather23.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.shanin.yandexweather23.R;
import ru.shanin.yandexweather23.api.APIServiceConstructor;
import ru.shanin.yandexweather23.api.config.APIConfigYandexWeather;
import ru.shanin.yandexweather23.api.config.APIServiceYandexWeather;
import ru.shanin.yandexweather23.data.City;

public class Main extends AppCompatActivity {
    private TextView textView;
    private SwipeRefreshLayout refreshLayout;
    private APIServiceYandexWeather service;
    private City city;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createService();
        initView();
    }

    private void initView() {
        textView = findViewById(R.id.tw_weather);
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this::loadData);
    }

    private void createService() {
        service = APIServiceConstructor.CreateService(
                APIServiceYandexWeather.class,
                APIConfigYandexWeather.HOST_URL);
        city = new City(56.50, 60.35);     //Ekb
        //city = new City( 55.74, 37.62);     //Msc
    }

    private void loadData() {
        refreshLayout.setRefreshing(true);
        Call<String> call_get = service.getGetCityWeather_v2(
                //APIConfigYandexWeather.KEY,
                city.getLat(), city.getLon()
        );
        call_get.enqueue(new Callback<String>() {
            @Override
            public void onResponse(
                    @NonNull Call<String> call,
                    @NonNull Response<String> response
            ) {
                if (response.body() != null) {
                    textView.setText(response.body());
                    Toast.makeText(
                            getApplicationContext(),
                            response.body(),
                            Toast.LENGTH_LONG
                    ).show();
                }
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(
                    @NonNull Call<String> call,
                    @NonNull Throwable t
            ) {
                textView.setText(t.toString());
                Toast.makeText(
                        getApplicationContext(),
                        t.toString(),
                        Toast.LENGTH_LONG
                ).show();
                refreshLayout.setRefreshing(false);
            }
        });
    }
}