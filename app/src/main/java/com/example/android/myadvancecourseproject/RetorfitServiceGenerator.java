package com.example.android.myadvancecourseproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.myadvancecourseproject.response.PrayerClass;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetorfitServiceGenerator {


    public static final String API_BASE_URL = "https://api.aladhan.com/v1/";
    private static OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);

    }


    public static class TestRetrofitActivity extends AppCompatActivity {
        RetrofitInterface rInterface = createService(RetrofitInterface.class);
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
}
