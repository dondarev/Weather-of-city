package com.example.weather_of_city_java.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {CityModel.class}, version = 1)
public abstract class AppDatabas extends RoomDatabase {
    public abstract CityModelDao cityModelDao();
}
