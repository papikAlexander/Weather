package com.alex.weather.modelDB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by alex on 22.03.18.
 */
@Entity(tableName = "weather")
public class WeatherModelDB {
    @PrimaryKey
    @NonNull
    public int id;
    public String data;
    public double temp;
    public double pressure;
    public double humidity;
    public int clouds;
    public String weather;
    public String weatherDescription;
    public double windSpeed;

    @Override
    public String toString() {
        return "WeatherModelDB{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", clouds=" + clouds +
                ", weather='" + weather + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
