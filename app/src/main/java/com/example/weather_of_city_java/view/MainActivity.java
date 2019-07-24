package com.example.weather_of_city_java.view;




import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.weather_of_city_java.model.db.CityModel;
import com.example.weather_of_city_java.model.location.MyLocationListener;
import com.example.weather_of_city_java.R;
import com.example.weather_of_city_java.viewmodel.MyViewModel;
import com.example.weather_of_city_java.databinding.ActivityMainBinding;
import com.jakewharton.rxbinding.view.RxView;


public class MainActivity extends AppCompatActivity  {


    ListView listView ;
    Button button;
    EditText editText;
    MyViewModel myViewModel;
    ArrayAdapter<String> adapter ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MyLocationListener.SetUpLocationListener(this);


        //нахоим список
        listView  = findViewById(R.id.listView);

        //находим кнопку
        button = findViewById(R.id.button);

        //Находим окно вывода текста
        editText = findViewById(R.id.editText);

        //Добавляем класс вьюмодел
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);//переходим во вьюмодел

        //Добавляем лайфцикл на вьюмодел
        getLifecycle().addObserver(myViewModel);

        //Создаем адаптер
        adapter  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        //присваеваем  списку адаптер
        listView.setAdapter(adapter);

        //заполняем адаптер
        myViewModel.getAllcity().observe(this, cityModels -> {
            adapter.clear();
            for(CityModel c:cityModels){
                adapter.add(c.getName() + "    "+ c.getTemperature() + " C");
            }
        });



        RxView.clicks(button)
                .subscribe(aVoid -> {
                    //получаем название нового города
                    String namecity = editText.getText().toString();
                    myViewModel.addcity(namecity);
                    editText.setText("");
                });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Object listItem = listView.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this,InfoCity.class);
            intent.putExtra("idcity", id);
            startActivity(intent);
        });
    }

}
