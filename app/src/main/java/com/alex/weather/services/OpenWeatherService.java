package com.alex.weather.services;

import com.alex.weather.modelWeb.WeatherModelWeb;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alex on 21.03.18.
 */

public interface OpenWeatherService {

    @GET("data/2.5/forecast?units=metric")
    Flowable<WeatherModelWeb> getData(@Query("id") int id, @Query("APPID") String appid);

}
