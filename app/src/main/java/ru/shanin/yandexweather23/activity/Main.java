package ru.shanin.yandexweather23.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.shanin.yandexweather23.R;
import ru.shanin.yandexweather23.api.APIServiceConstructor;
import ru.shanin.yandexweather23.api.config.APIConfigYandexWeather;
import ru.shanin.yandexweather23.api.config.APIServiceYandexWeather;

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
        textView = findViewById(R.id.tw_weather);
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this::localHost);
        newCity();
        localHost();
    }


    private void localHost() {
        service = APIServiceConstructor.CreateService(
                APIServiceYandexWeather.class,
                APIConfigYandexWeather.HOST_URL);
        loadData();

    }

    private void loadData() {
        refreshLayout.setRefreshing(true);
        Call<String> call_get = service.getDataGET(city.getLat(), city.getLon());
        call_get.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body() != null) {
                    textView.setText(response.body());
                    Toast.makeText(getApplicationContext(), response.body(), Toast.LENGTH_LONG).show();
                }
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                textView.setText(t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void newCity() {
        //Ekb
        city = new City(56.50, 60.35);
        //Msc
        //city = new City( 55.74, 37.62);
    }
}

class City {
    private final double lat;
    private final double lon;

    public City(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}