package com.example.weather_of_city_java.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;


@Dao
public interface CityModelDao {
    @Query("SELECT * FROM CITYMODEL")
    Flowable<List<CityModel>> getAll();

    @Query("SELECT * FROM CITYMODEL WHERE id = :id")
    Flowable<CityModel> getById(long id);

    @Query("SELECT * FROM CITYMODEL WHERE name = :name")
    Flowable<CityModel> getByName(String name);

    @Query("DELETE  FROM CITYMODEL WHERE name = :name")
    void  deleteCiy(String name);

    @Insert
    long insert(CityModel cityModel );

    @Update
    void update(CityModel cityModel );

    @Delete
    void delete(CityModel cityModel);
}
