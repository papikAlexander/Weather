package com.alex.weather.modelWeb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alex on 21.03.18.
 */

public class WeatherModelWeb {

    @SerializedName("city")
    @Expose
    private City city;

    @SerializedName("list")
    @Expose
    private List<WeatherListWeb> list;


    @Override
    public String toString() {
        return "WeatherModelWeb{" +
                "city=" + city +
                ", list=" + list +
                '}';
    }

    public List<WeatherListWeb> getList() {
        return list;
    }

    public void setList(List<WeatherListWeb> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public class City {


        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("country")
        @Expose
        private String country;

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

    }
}
