package com.example.weather_of_city_java.model.networkservice.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {
    @SerializedName("cod")
    String cod;
    @SerializedName("message")
    float message;
    @SerializedName("city")
    City city;
    @SerializedName("cnt")
    int cnt;
    @SerializedName("list")
    List<DataWeather> list;


    public class DataWeather {
        @SerializedName("dt")
        long dt;
        @SerializedName("weather")
        List<Weather> weather;
        @SerializedName("clouds")
        Openweathermap.Clouds clouds;
        @SerializedName("main")
        Main main;
        @SerializedName("wind")
        Openweathermap.Wind wind;
        @SerializedName("rain")
        Rain rain;
        @SerializedName("sys")
        Sys sys;
        @SerializedName("dt_txt")
        String dt_txt;


        @Override
        public String toString() {
            return "{" +
                    "dt:" + dt +
                    ", weather:" + weather +
                    ", clouds:" + clouds +
                    ", main:" + main +
                    ", wind:" + wind +
                    ", rain:" + rain +
                    ", sys:" + sys +
                    ", dt_txt:'" + dt_txt + '\'' +
                    '}';
        }

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public Openweathermap.Clouds getClouds() {
            return clouds;
        }

        public void setClouds(Openweathermap.Clouds clouds) {
            this.clouds = clouds;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public Openweathermap.Wind getWind() {
            return wind;
        }

        public void setWind(Openweathermap.Wind wind) {
            this.wind = wind;
        }

        public Rain getRain() {
            return rain;
        }

        public void setRain(Rain rain) {
            this.rain = rain;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public String getDt_txt() {
            return dt_txt;
        }

        public void setDt_txt(String dt_txt) {
            this.dt_txt = dt_txt;
        }
    }



    public class City {
        @SerializedName("name")
        String name;
        @SerializedName("country")
        String country;
        @SerializedName("population")
        long population;
        @SerializedName("id")
        long id;
        @SerializedName("coord")
        Openweathermap.Coord coord;
        @SerializedName("timezone")
        long timezone;

        @Override
        public String toString() {
            return "{" +
                    "name:'" + name + '\'' +
                    ", country:'" + country + '\'' +
                    ", population:" + population +
                    ", id:" + id +
                    ", coord:" + coord +
                    ", timezone:" + timezone +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPopulation() {
            return String.valueOf(population);
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCoord() {
            return String.valueOf(coord);
        }

        public void setCoord(Openweathermap.Coord coord) {
            this.coord = coord;
        }

        public long getTimezone() {
            return timezone;
        }

        public void setTimezone(long timezone) {
            this.timezone = timezone;
        }
    }
    public class Weather {
        @SerializedName("id")
        long id;
        @SerializedName("main")
        String main;
        @SerializedName("description")
        String description;
        @SerializedName("icon")
        String icon;

        @Override
        public String toString() {
            return "{" +
                    "id:" + id +
                    ", main:'" + main + '\'' +
                    ", description:'" + description + '\'' +
                    ", icon:'" + icon + '\'' +
                    '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
    public class Rain {
        @SerializedName("3h")
        float h;

        @Override
        public String toString() {
            return "{" +
                    "h:" + h +
                    '}';
        }

        public float getH() {
            return h;
        }

        public void setH(float h) {
            this.h = h;
        }
    }
    public class Main {
        @SerializedName("temp")
        float temp;
        @SerializedName("temp_min")
        float temp_min;
        @SerializedName("temp_max")
        float temp_max;
        @SerializedName("pressure")
        float pressure;
        @SerializedName("sea_level")
        float sea_level;
        @SerializedName("grnd_level")
        float grnd_level;
        @SerializedName("humidity")
        int  humidity;
        @SerializedName("temp_kf")
        float temp_kf;

        @Override
        public String toString() {
            return "{" +
                    "  temp:" + temp +
                    ", temp_min:" + temp_min +
                    ", temp_max:" + temp_max +
                    ", pressure:" + pressure +
                    ", sea_level:" + sea_level +
                    ", grnd_level:" + grnd_level +
                    ", humidity:" + humidity +
                    ", temp_kf:" + temp_kf +
                    '}';
        }


        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(float temp_min) {
            this.temp_min = temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(float temp_max) {
            this.temp_max = temp_max;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public float getSea_level() {
            return sea_level;
        }

        public void setSea_level(float sea_level) {
            this.sea_level = sea_level;
        }

        public float getGrnd_level() {
            return grnd_level;
        }

        public void setGrnd_level(float grnd_level) {
            this.grnd_level = grnd_level;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public float getTemp_kf() {
            return temp_kf;
        }

        public void setTemp_kf(float temp_kf) {
            this.temp_kf = temp_kf;
        }
    }
    public class Sys {
        @SerializedName("pod")
        String pod;

        @Override
        public String toString() {
            return "{" +
                    "pod:'" + pod + '\'' +
                    '}';
        }

        public void setPod(String pod) {
            this.pod = pod;
        }

        public String getPod() {
            return pod;
        }
    }


    @Override
    public String toString() {
        return "{" +
                "cod:'" + cod + '\'' +
                ", message:" + message +
                ", city:" + city +
                ", cnt:" + cnt +
                ", list:" + list +
                '}';
    }


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<DataWeather> getList() {
        return list;
    }

    public void setList(List<DataWeather> list) {
        this.list = list;
    }
}
