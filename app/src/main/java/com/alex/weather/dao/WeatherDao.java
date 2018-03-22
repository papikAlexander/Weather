package com.alex.weather.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.alex.weather.modelDB.WeatherModelDB;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by alex on 22.03.18.
 */

@Dao
public interface WeatherDao {

    @Insert
    void insert(List<WeatherModelDB> list);

    @Delete
    void delete(WeatherModelDB weatherModelDB);

    @Query("SELECT * FROM weather")
    Flowable<List<WeatherModelDB>> getAll();

    @Update
    void update(List<WeatherModelDB> list);
}

