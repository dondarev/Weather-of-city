package com.example.weather_of_city_java.dagger;

import com.example.weather_of_city_java.model.Model;

import dagger.Component;

@Component(modules = ModelModule.class)
public interface AppComponent {
    Model getModel();
}
