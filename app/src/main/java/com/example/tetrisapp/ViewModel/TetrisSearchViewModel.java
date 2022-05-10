package com.example.tetrisapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tetrisapp.Adapter.TetrisSearchResultsAdapter;
import com.example.tetrisapp.Model.Tetris;
import com.example.tetrisapp.Model.TetrisResponse;
import com.example.tetrisapp.Repositories.TetrisRepository;

public class TetrisSearchViewModel extends AndroidViewModel {

    private TetrisRepository tetrisRepository;
    private LiveData<TetrisResponse> tetrisLiveData;

    public TetrisSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        tetrisRepository = new TetrisRepository();
        tetrisLiveData = tetrisRepository.getTetrisLiveData();
    }

    public void searchTetris(String keyword) {
        tetrisRepository.searchTetris(keyword);
    }

    public LiveData<TetrisResponse> getTetrisLiveData() {
        return tetrisLiveData;
    }
}
