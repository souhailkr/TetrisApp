package com.example.tetrisapp.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tetrisapp.Adapter.TetrisSearchResultsAdapter;
import com.example.tetrisapp.Model.Tetris;
import com.example.tetrisapp.Model.TetrisResponse;
import com.example.tetrisapp.R;
import com.example.tetrisapp.ViewModel.TetrisSearchViewModel;


public class TetrisSearchFragment extends Fragment {

    private TetrisSearchViewModel viewModel;
    private TetrisSearchResultsAdapter adapter;

    private Button searchButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    adapter = new TetrisSearchResultsAdapter(getContext());

    viewModel = ViewModelProviders.of(this).get(TetrisSearchViewModel.class);
        viewModel.init();
        viewModel.getTetrisLiveData().observe(this, new Observer<TetrisResponse>() {
        @Override
        public void onChanged(TetrisResponse terisResponse) {
            if (terisResponse != null) {
                adapter.setResults(terisResponse.getItems());
            }
        }
    });
}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tetris_search, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_tetris_searchResultsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        searchButton = view.findViewById(R.id.searchBtn);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        return view;
    }

    public void performSearch() {
        String keyword = "tetris";
        viewModel.searchTetris(keyword);
    }
}