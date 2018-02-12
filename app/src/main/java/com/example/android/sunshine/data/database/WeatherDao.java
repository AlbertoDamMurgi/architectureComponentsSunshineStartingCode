package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */
@Dao
public interface WeatherDao {

   @Insert (onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(WeatherEntry... weather);

   @Query("SELECT count(id) from weather where date>=:date")
   int countAllFutureWeather(Date date);

   @Query("delete from weather where date< :date")
   void deleteOldWeather(Date date);

   @Query("SELECT * FROM weather WHERE date =:date")
    LiveData<WeatherEntry> getWeatherByDate(Date date);

    @Query("select * from weather where date >= :date")
    LiveData<List<WeatherEntry>> getCurrentWeatherForecasts(Date today);
}
