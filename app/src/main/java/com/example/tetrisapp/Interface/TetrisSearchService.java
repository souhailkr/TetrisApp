package com.example.tetrisapp.Interface;

import com.example.tetrisapp.Model.Tetris;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TetrisSearchService {
    @GET("search/repositories")
    Call<Tetris> searchTetris(
            @Query("q") String query
    );
}
