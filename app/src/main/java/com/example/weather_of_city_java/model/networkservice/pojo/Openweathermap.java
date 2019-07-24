package com.example.weather_of_city_java.model.networkservice.pojo;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Openweathermap {

    @SerializedName("coord")
   private Coord coord;
    @SerializedName("weather")
   private List<Weather> weather;
    @SerializedName("base")
   private String base;
    @SerializedName("main")
   private Main main;
    @SerializedName("visibility")
   private String visibility;
    @SerializedName("wind")
   private Wind wind;
    @SerializedName("clouds")
   private Clouds clouds;
    @SerializedName("dt")
   private String dt;
    @SerializedName("sys")
   private Sys sys;
    @SerializedName("timezone")
   private String timezone;
    @SerializedName("id")
   private String id;
    @SerializedName("name")
   private String name;
    @SerializedName("cod")
   private int cod;

    public Openweathermap() {

    }

    public class Coord{
        @SerializedName("lon")
        float lon;
        @SerializedName("lat")
        float lat;

        public float getLon() {
            return lon;
        }

        public float getLat() {
            return lat;
        }

        @NotNull
        @Override
        public String toString() {
            return "" +
                    "lon=" + lon +
                    ", lat=" + lat;
        }
    }
    public class Weather{
        @SerializedName("id")
        int id;
        @SerializedName("main")
        String main;
        @SerializedName("description")
        String description;
        @SerializedName("icon")
        String icon;

        @Override
        public String toString() {
            return "Weather{" +
                    "id=" + id +
                    ", main='" + main + '\'' +
                    ", description='" + description + '\'' +
                    ", icon='" + icon + '\'' +
                    '}';
        }
    }
    public class Main{
        @SerializedName("temp")
        float temp;
        @SerializedName("pressure")
        long pressure;
        @SerializedName("humidity")
        int  humidity;
        @SerializedName("temp_min")
        float temp_min;
        @SerializedName("temp_max")
        float temp_max;

        public float getTemp() {
            return temp;
        }

        public long getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temp=" + temp +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", temp_min=" + temp_min +
                    ", temp_max=" + temp_max +
                    '}';
        }
    }
    public class Wind{
        @SerializedName("speed")
        float speed;
        @SerializedName("deg")
        float deg;

        @Override
        public String toString() {
            return "Wind{" +
                    "speed=" + speed +
                    ", deg=" + deg +
                    '}';
        }
    }
    public class Clouds{
        @SerializedName("all")
        int all;

        @Override
        public String toString() {
            return "Clouds{" +
                    "all=" + all +
                    '}';
        }
    }
    public class Sys{
        @SerializedName("type")
        int type;
        @SerializedName("id")
        int id;
        @SerializedName("message")
        float message;
        @SerializedName("country")
        String country;
        @SerializedName("sunrise")
        long sunrise;
        @SerializedName("sunset")
        long sunset;

        @Override
        public String toString() {
            return "Sys{" +
                    "type=" + type +
                    ", id=" + id +
                    ", message=" + message +
                    ", country='" + country + '\'' +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    '}';
        }
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Openweathermap{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility='" + visibility + '\'' +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt='" + dt + '\'' +
                ", sys=" + sys +
                ", timezone='" + timezone + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
