package com.example.weather_of_city_java.dagger;

import com.example.weather_of_city_java.model.Model;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {

    @Provides
    Model provideModuleUtils(){
            return new Model();
    }
}
