package com.example.tetrisapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tetrisapp.Model.Owner;
import com.example.tetrisapp.Model.Tetris;
import com.example.tetrisapp.R;

import java.util.ArrayList;
import java.util.List;

public class TetrisSearchResultsAdapter extends RecyclerView.Adapter<TetrisSearchResultsAdapter.TetrisSearchResultHolder> {
    private List<Tetris> results = new ArrayList<>();

    @NonNull
    @Override
    public TetrisSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tetris_item, parent, false);

        return new TetrisSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TetrisSearchResultHolder holder, int position) {
        Tetris tetris = results.get(position);

        holder.titleTextView.setText(tetris.getName());
        holder.sizeTextView.setText(tetris.getSize());

        Owner owner = tetris.getOwner() ;
        if (owner != null) {
            String ownerName = owner.getName();
            holder.ownerTextView.setText(ownerName);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<Tetris> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class TetrisSearchResultHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView ownerTextView;
        private TextView sizeTextView;
        private ImageView tetrisImageView;

        public TetrisSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.tetris_item_title);
            ownerTextView = itemView.findViewById(R.id.tetris_item_owner);
            sizeTextView = itemView.findViewById(R.id.tetris_item_size);
            tetrisImageView = itemView.findViewById(R.id.tetris_item_smallThumbnail);
        }
    }
}

