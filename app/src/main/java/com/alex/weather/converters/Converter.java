package com.alex.weather.converters;

import com.alex.weather.modelDB.WeatherModelDB;
import com.alex.weather.modelWeb.WeatherListWeb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 22.03.18.
 */

public class Converter {


    public static List<WeatherModelDB> modelWebToModelDB(List<WeatherListWeb> listWebs){

        WeatherModelDB modelDB;
        List<WeatherModelDB> listDB = new ArrayList(listWebs.size());
        WeatherListWeb modelWeb;

        for(int i = 0; i < listWebs.size(); i++){

            modelDB = new WeatherModelDB();
            modelWeb = listWebs.get(i);

            modelDB.id = i;
            modelDB.data = modelWeb.getData();
            modelDB.clouds = modelWeb.getClouds().getAll();
            modelDB.humidity = modelWeb.getMain().getHumidity();
            modelDB.pressure = modelWeb.getMain().getPressure();
            modelDB.temp = modelWeb.getMain().getTemp();
            modelDB.weather = modelWeb.getWeathers().get(0).getMain();
            modelDB.weatherDescription = modelWeb.getWeathers().get(0).getDescription();
            modelDB.windSpeed = modelWeb.getWind().getSpeed();

            listDB.add(modelDB);

        }

        return listDB;
    }

}
