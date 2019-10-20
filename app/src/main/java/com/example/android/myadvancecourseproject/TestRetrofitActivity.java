package com.example.android.myadvancecourseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android.myadvancecourseproject.response.PrayerClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TestRetrofitActivity extends AppCompatActivity {
    RetrofitInterface rInterface = RetorfitServiceGenerator.createService(RetrofitInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit2);

    rInterface.getTimings(51.508515,0.1254872, 2,4, 2017 ).enqueue(new Callback<PrayerClass>() {
        @Override
        public void onResponse(Call<PrayerClass> call, Response<PrayerClass> response) {
            Log.i("MY", response.body().getData().get(0).getTimings().getSunrise() ) ;
        }

        @Override
        public void onFailure(Call<PrayerClass> call, Throwable t) {

        }
    });
    }
}
