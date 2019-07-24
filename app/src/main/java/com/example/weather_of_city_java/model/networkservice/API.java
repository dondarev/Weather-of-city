package com.example.weather_of_city_java.model.networkservice;


import com.example.weather_of_city_java.model.networkservice.pojo.Forecast;
import com.example.weather_of_city_java.model.networkservice.pojo.Openweathermap;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface API {
    @GET("data/2.5/weather")
     Observable <Openweathermap>  getWatherfromcity(@Query(value = "q",encoded = true) String namecity, @Query("APPID") String appid);

    @GET("data/2.5/weather")
    Observable<Openweathermap> getWeatherlocation(@Query(value = "lat") double lat,@Query(value = "lon") double lon,@Query(value = "cnt") int cnt, @Query("APPID") String appid);

    @GET("data/2.5/forecast")

    Observable<Forecast> getWeatherFoFewDey(@Query(value = "q",encoded = true) String namecity, @Query("APPID") String appid,@Query("cnt") int cnt);


}
