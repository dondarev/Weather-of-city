package com.example.weather_of_city_java.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CityModel {

    @PrimaryKey(autoGenerate = true)
    long id;//id

    //ИНазвание города
    String name;

    //Температура в городе
    String temperature;

    //Долгота
    float longitude;

    //Широта
    float latitude;


    public CityModel( String name, String temperature, float longitude, float latitude) {

        this.name = name;
        this.temperature = temperature;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public CityModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
