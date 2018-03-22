package com.alex.weather;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.alex.weather.db.AppDatabase;

/**
 * Created by alex on 22.03.18.
 */

public class App extends Application {

    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "weather_database")
                .build();

    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
