package com.example.android.myadvancecourseproject;

import com.example.android.myadvancecourseproject.response.PrayerClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("calendar")
    Call<PrayerClass> getTimings(@Query("latitude") Double lat,@Query("longitude") Double lng,@Query("method")int method,@Query("month") int month,@Query("year") int year  );

}
