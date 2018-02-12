package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.WeatherEntry;

import java.util.List;

/**
 * Created by usuario on 12/02/18.
 */

public class MainViewModel extends ViewModel {

    private final SunshineRepository mRepository;
    private final LiveData<List<WeatherEntry>> mForecast;

    public MainViewModel(SunshineRepository mRepository) {
        this.mRepository = mRepository;
        this.mForecast = mRepository.getCurrentWeatherForecast();
    }

    public LiveData<List<WeatherEntry>> getForecast() {
        return mForecast;
    }
}
