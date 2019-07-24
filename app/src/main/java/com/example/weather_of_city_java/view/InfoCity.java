package com.example.weather_of_city_java.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weather_of_city_java.R;
import com.example.weather_of_city_java.databinding.ActivityInfoCityBinding;
import com.example.weather_of_city_java.model.networkservice.pojo.Forecast;
import com.example.weather_of_city_java.viewmodel.MyViewModel;

public class InfoCity extends AppCompatActivity {

    MyViewModel myViewModel;
    TextView country;
    TextView namecity;
    TextView population;
    TextView coord;
    ArrayAdapter<String> adapter ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_info_city);


        ActivityInfoCityBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_info_city);


        country = findViewById(R.id.countryValues);
        namecity = findViewById(R.id.namevalue);
        population = findViewById(R.id.cntcitizenvalue);
        coord = findViewById(R.id.coordvalue);
        listView = findViewById(R.id.listweather);
        //Создаем адаптер
        adapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        //Добавляем класс вьюмодел
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);//переходим во вьюмодел
        long id = getIntent().getLongExtra("idcity",0);
        myViewModel.getInfofromcity(id+1,4).observe(this,forecast -> {
            binding.setCity(forecast.getCity());


            for (int i =0;i<forecast.getList().size();i++){

                adapter.add("Via "+(i+1)+"days \n" +
                        "Expected temp. : "+Math.round(forecast.getList().get(i).getMain().getTemp()- 273)+" C \n"+
                        "Max. temp. : "+Math.round(forecast.getList().get(i).getMain().getTemp_max()-273)+" C \n"+
                        "Min. temp. : "+Math.round(forecast.getList().get(i).getMain().getTemp_min()-273)+" \n"+
                        "Weather : "+forecast.getList().get(i).getWeather().get(0).getDescription()+".");
            }
        });
    }
}
