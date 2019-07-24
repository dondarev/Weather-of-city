package com.example.weather_of_city_java.model.networkservice;


import com.example.weather_of_city_java.BuildConfig;


import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;


public class Client {
    private static Client mInstance = new Client();
    private static API api;
    private static final String BASE_URL = "http://api.openweathermap.org/";

    public static Client getInstance(){
        return mInstance;
    }

    private Client(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel((BuildConfig.DEBUG) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();

        api = retrofit.create(API.class);
    }
    public API getApi() {
        return api;
    }
}
