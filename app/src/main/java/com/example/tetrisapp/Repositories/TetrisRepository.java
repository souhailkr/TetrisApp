package com.example.tetrisapp.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tetrisapp.Interface.TetrisSearchService;
import com.example.tetrisapp.Model.Tetris;
import com.example.tetrisapp.Model.TetrisResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class TetrisRepository {
    private static final String TETRIS_SEARCH_SERVICE_BASE_URL = "https://api.github.com/";

    private TetrisSearchService tetrisSearchService;
    private MutableLiveData<TetrisResponse> tetrisResponseLiveData;

    public TetrisRepository() {
        tetrisResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        tetrisSearchService = new retrofit2.Retrofit.Builder()
                .baseUrl(TETRIS_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TetrisSearchService.class);

    }

    public void searchTetris(String keyword) {
        tetrisSearchService.searchTetris(keyword)
                .enqueue(new Callback<TetrisResponse>() {
                    @Override
                    public void onResponse(Call<TetrisResponse> call, Response<TetrisResponse> response) {
                        if (response.body() != null) {
                            tetrisResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<TetrisResponse> call, Throwable t) {
                        tetrisResponseLiveData.postValue(null);
                    }
                });
    }

    public LiveData<TetrisResponse> getTetrisLiveData() {
        return tetrisResponseLiveData;
    }
}