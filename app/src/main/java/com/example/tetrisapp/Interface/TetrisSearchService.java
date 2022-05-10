package com.example.tetrisapp.Interface;

import com.example.tetrisapp.Model.TetrisResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TetrisSearchService {
    @GET("search/repositories")
    Call<TetrisResponse> searchTetris(
            @Query("q") String query
    );
}
