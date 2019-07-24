package com.example.weather_of_city_java.model.networkservice;

import com.example.weather_of_city_java.model.networkservice.pojo.Openweathermap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class NetworkSevice {
    private API api  = Client.getInstance().getApi();
    public Openweathermap pojo;

    public void getwathercity(String namesity, String appid) {

        api.getWatherfromcity(namesity,appid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer <Openweathermap >() {

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
                        pojo = openweathermap;
                    }
                });
    }


}
