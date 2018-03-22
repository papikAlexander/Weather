package com.alex.weather.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.alex.weather.dao.WeatherDao;
import com.alex.weather.modelDB.WeatherModelDB;

/**
 * Created by alex on 22.03.18.
 */
@Database(entities = {WeatherModelDB.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract WeatherDao getWeatherDao();
}
