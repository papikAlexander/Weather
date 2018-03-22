package com.alex.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.alex.weather.adapters.MyAdapter;
import com.alex.weather.converters.Converter;
import com.alex.weather.db.AppDatabase;
import com.alex.weather.modelDB.WeatherModelDB;
import com.alex.weather.modelWeb.WeatherModelWeb;
import com.alex.weather.services.OpenWeatherService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "http://api.openweathermap.org/";

    private final int ID = 703448;
    private final String APPID = "7918052be55948f196b7d17d206caea5";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private AppDatabase db;

    Retrofit retrofit;
    Flowable<WeatherModelWeb> flowable;
    Flowable<List<WeatherModelDB>> flowableList;
    OpenWeatherService service;

    TextView textViewCity;
    TextView textViewCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCity = (TextView) findViewById(R.id.textViewCity);
        textViewCountry = (TextView) findViewById(R.id.textViewCountry);

        db = App.getInstance().getDatabase();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        service = retrofit.create(OpenWeatherService.class);

        flowable = service.getData(ID, APPID);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(modelWEB -> {
                    textViewCity.setText(modelWEB.getCity().getName());
                    textViewCountry.setText(modelWEB.getCity().getCountry());
                    return Converter.modelWebToModelDB(modelWEB.getList());
                })
                .subscribe(modelDB -> {

                    Completable.fromAction(() -> db.getWeatherDao().update(modelDB))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe();

                });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);



        flowableList = db.getWeatherDao().getAll();
        flowableList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    mAdapter = new MyAdapter(list);
                    mRecyclerView.setAdapter(mAdapter);
                });

    }

}
