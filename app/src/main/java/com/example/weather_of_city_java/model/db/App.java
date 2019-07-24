package com.example.weather_of_city_java.model.db;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.weather_of_city_java.dagger.AppComponent;
import com.example.weather_of_city_java.dagger.DaggerAppComponent;

public class App extends Application {
    public static App instance;
    private AppDatabas database;
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabas.class, "database")
                .build();

        component = DaggerAppComponent.create();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabas getDatabase() {
        return database;
    }

    public static AppComponent getComponent() {
        return component;
    }
}
