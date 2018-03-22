package com.alex.weather.modelWeb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alex on 21.03.18.
 */

public class WeatherListWeb {

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("weather")
    @Expose
    private List<Weather> weathers;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("dt_txt")
    @Expose
    private String data;

    @Override
    public String toString() {
        return "WeatherListWeb{" +
                "main=" + main +
                ", clouds=" + clouds +
                ", weathers=" + weathers +
                ", wind=" + wind +
                ", data='" + data + '\'' +
                '}';
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }



    public class Clouds {

        @SerializedName("all")
        @Expose
        private Integer all;

        @Override
        public String toString() {
            return "Clouds{" +
                    "all=" + all +
                    '}';
        }

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }
    }

    public class Main {

        @SerializedName("temp")
        @Expose
        private Double temp;

        @SerializedName("pressure")
        @Expose
        private Double pressure;

        @SerializedName("humidity")
        @Expose
        private Double humidity;

        @Override
        public String toString() {
            return "Main{" +
                    "temp=" + temp +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    '}';
        }

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getHumidity() {
            return humidity;
        }

        public void setHumidity(Double humidity) {
            this.humidity = humidity;
        }
    }

    public class Weather {

        @SerializedName("main")
        @Expose
        private String main;

        @SerializedName("description")
        @Expose
        private String description;

        @Override
        public String toString() {
            return "WeatherModelDB{" +
                    "main='" + main + '\'' +
                    ", description='" + description + '\'' +
                    '}';
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
    }

    public class Wind {

        @SerializedName("speed")
        @Expose
        private Double speed;

        @Override
        public String toString() {
            return "Wind{" +
                    "speed=" + speed +
                    '}';
        }

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }
    }
}
