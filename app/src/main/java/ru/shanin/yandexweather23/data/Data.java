package ru.shanin.yandexweather23.data;

import androidx.annotation.NonNull;

public class Data {
    private final String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @NonNull
    @Override
    public String toString() {
        return "Data:\n" + data;
    }
}
