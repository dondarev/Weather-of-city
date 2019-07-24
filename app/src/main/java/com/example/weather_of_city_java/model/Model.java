package com.example.weather_of_city_java.model;


import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ProcessLifecycleOwner;

import com.example.weather_of_city_java.model.db.App;
import com.example.weather_of_city_java.model.db.AppDatabas;
import com.example.weather_of_city_java.model.db.CityModel;
import com.example.weather_of_city_java.model.db.CityModelDao;
import com.example.weather_of_city_java.model.location.MyLocationListener;
import com.example.weather_of_city_java.model.networkservice.API;
import com.example.weather_of_city_java.model.networkservice.Client;
import com.example.weather_of_city_java.model.networkservice.pojo.Forecast;
import com.example.weather_of_city_java.model.networkservice.pojo.Openweathermap;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class Model  {


    private API api  = Client.getInstance().getApi();//Апи ретрофит для получения запросов с сервера
    private AppDatabas  bd  = App.getInstance().getDatabase();

    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public Model() {
    }


    //get all city
    @SuppressLint("CheckResult")
    public  MutableLiveData<List<CityModel>> getAllCity() {
        CityModelDao modeldb = bd.cityModelDao();
        MutableLiveData<List<CityModel>> mas = new MutableLiveData<>();

        modeldb.getAll()
                .subscribe(arraycity -> {
                    mas.postValue(arraycity);
                });
        return mas;
    }

    //get weather fo city
    public MutableLiveData<Openweathermap> getweather(String city) {
        MutableLiveData<Openweathermap> dataWeather = new MutableLiveData<>();

        api.getWatherfromcity(city,"c9b0d27f1954af34df561b851a0ece07")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Openweathermap>() {

                    @Override
                    public void onCompleted() {
                        System.out.println("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Ouch!");
                    }

                    @Override
                    public void onNext(Openweathermap openweathermap) {
                        dataWeather.postValue(openweathermap);
                    }
                });
        return dataWeather;
    }

    // add city to bd
    public void addCity(CityModel city) {

        CityModelDao modeldb = bd.cityModelDao();
        mExecutor.execute(() -> {
            modeldb.insert(city);

        });
    }

    //add city to location
    public LiveData<Openweathermap> getweathercitylocation(int cnt){
        double lat = MyLocationListener.imHere.getLatitude();
        double lon = MyLocationListener.imHere.getLongitude();

        MutableLiveData<Openweathermap> objectMutableLiveData = new MutableLiveData<Openweathermap>();

        api.getWeatherlocation(lat,lon,cnt,"c9b0d27f1954af34df561b851a0ece07")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Openweathermap>() {

                    @Override
                    public void onCompleted() {

                        System.out.println("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {

                        System.out.println("Ouch!");
                    }

                    @Override
                    public void onNext(Openweathermap openweathermap) {
                        objectMutableLiveData.postValue(openweathermap);
                    }
                });
        return objectMutableLiveData;
    }


    public void deletecity(String namecityModel){
        CityModelDao dao = bd.cityModelDao();
        mExecutor.execute(() -> {
            dao.deleteCiy(namecityModel);
        });
    }



    public MutableLiveData<Forecast> getcityfoname(long id,int cnt) {
        MutableLiveData<Forecast> city = new MutableLiveData<>();
        CityModelDao modeldb = bd.cityModelDao();
        modeldb.getById(id).subscribe(cityModel -> getWeatherFoFewDay(cityModel.getName(),cnt).observe(ProcessLifecycleOwner.get(),openweathermap->{city.postValue(openweathermap);}));

        return city;
    }

    public MutableLiveData<Forecast> getWeatherFoFewDay(String city, int countday){
        MutableLiveData<Forecast> dataWeather = new MutableLiveData<>();
        api.getWeatherFoFewDey(city,"c9b0d27f1954af34df561b851a0ece07",countday).subscribe(new Observer<Forecast>() {
            @Override
            public void onCompleted() {

                System.out.println("Completed!");
            }
            @Override
            public void onError(Throwable e) {

                System.out.println("Ouch!");
            }
            @Override
            public void onNext(Forecast openweathermap) {
                dataWeather.postValue(openweathermap);
            }
        }
    );
        return dataWeather;
    }
}
