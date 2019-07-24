package com.example.weather_of_city_java.model;
import android.arch.lifecycle.MutableLiveData;

import com.example.weather_of_city_java.model.db.CityModel;
import com.example.weather_of_city_java.model.networkservice.pojo.Openweathermap;

import java.util.List;

import rx.Observable;

public interface IModel {

    //Добавленеи города в базу
    Observable<CityModel> AddCity(CityModel city );
    //Получение списка городов из базы
    MutableLiveData<List<CityModel>> getAllCity();

    MutableLiveData<Openweathermap> getweather(String city);

}
