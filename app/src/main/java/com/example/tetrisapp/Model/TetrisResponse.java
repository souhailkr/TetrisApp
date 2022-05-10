package com.example.tetrisapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TetrisResponse {

    @SerializedName("total_count")
    @Expose
    private long total_count;

    @SerializedName("items")
    @Expose
    List<Tetris> items = null;

    @SerializedName("incomplete_results")
    @Expose
    boolean incomplete_results;

    public long getTotal_count() {
        return total_count;
    }

    public List<Tetris> getItems() {
        return items;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }
}
