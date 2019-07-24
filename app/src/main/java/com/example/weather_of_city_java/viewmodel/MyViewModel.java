package com.example.weather_of_city_java.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.arch.lifecycle.ViewModel;

import com.example.weather_of_city_java.model.Model;
import com.example.weather_of_city_java.model.db.App;
import com.example.weather_of_city_java.model.db.CityModel;
import com.example.weather_of_city_java.model.networkservice.pojo.Forecast;
import com.example.weather_of_city_java.model.networkservice.pojo.Openweathermap;

import java.util.List;

public class MyViewModel extends ViewModel  implements LifecycleObserver{


    MutableLiveData<List<CityModel>> mas;//массив городов
    Model model = App.getComponent().getModel();
    CityModel citylocation; // локальный город
    CityModel defaultcity;//город по дефолту


    public MyViewModel() {
    }

    //get weather fo city
    public MutableLiveData<Openweathermap> getweathgercity(String city) {
        MutableLiveData<Openweathermap> dt;
        dt   = model.getweather(city);
        return dt;
    }

    //get list city from bd
    public MutableLiveData<List<CityModel>> getAllcity() {
        if (mas == null){
            mas = model.getAllCity();
            return mas;
        }
        else {
            return mas;
        }
    }

    //add city to bd
    public  void addCitytToBD(CityModel city){
        model.addCity(city);
    }

    //add city
    public void addcity(String name){
        getweathgercity(name + ",ua")
                .observe(ProcessLifecycleOwner.get(), openweathermap -> {
                    CityModel cityModel = new CityModel();
                    assert openweathermap != null;
                    cityModel.setName(openweathermap.getName());
                    cityModel.setTemperature(String.valueOf(Math.round(openweathermap.getMain().getTemp() - 273)));
                    cityModel.setLatitude(openweathermap.getCoord().getLat());
                    cityModel.setLongitude(openweathermap.getCoord().getLon());
                    //добавляем  город в базу
                    addCitytToBD(cityModel);
                });
    }

    //get weather from location
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public  void getweatherfromlocation(){

        if(citylocation ==null){
            model.getweathercitylocation(3).observe(ProcessLifecycleOwner.get(),openweathermap-> {
                CityModel cityModel = new CityModel();
                cityModel.setName(openweathermap.getName());
                cityModel.setTemperature(String.valueOf(Math.round(openweathermap.getMain().getTemp() - 273)));
                cityModel.setLatitude(openweathermap.getCoord().getLat());
                cityModel.setLongitude(openweathermap.getCoord().getLon());
                cityModel.setId(0);
                addCitytToBD(cityModel);
                citylocation = cityModel;
            });
        }

        if (defaultcity == null){
            model.getweather("Dnipropetrovsk").observe(ProcessLifecycleOwner.get(), openweathermap-> {
                CityModel cityModel = new CityModel();
                cityModel.setName(openweathermap.getName());
                cityModel.setTemperature(String.valueOf(Math.round(openweathermap.getMain().getTemp() - 273)));
                cityModel.setLatitude(openweathermap.getCoord().getLat());
                cityModel.setLongitude(openweathermap.getCoord().getLon());
                cityModel.setId(0);
                addCitytToBD(cityModel);
                defaultcity = cityModel;
            });
        }
    }

    //PAUSE()
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void deletecity(){
        mas = null;
        System.out.println("Local city delete");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void clear(){
        model.deletecity(citylocation.getName());
        model.deletecity(defaultcity.getName());
        citylocation = null;
        defaultcity = null;
        mas =null;

    }

    public MutableLiveData<Forecast> getInfofromcity(long id, int cnt) {
        return model.getcityfoname(id,cnt);
    }



}
