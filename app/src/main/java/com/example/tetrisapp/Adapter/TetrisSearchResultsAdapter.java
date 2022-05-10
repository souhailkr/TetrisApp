package com.example.tetrisapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tetrisapp.Model.Owner;
import com.example.tetrisapp.Model.Tetris;
import com.example.tetrisapp.R;

import java.util.ArrayList;
import java.util.List;

public class TetrisSearchResultsAdapter extends RecyclerView.Adapter<TetrisSearchResultsAdapter.TetrisSearchResultHolder> {
    private List<Tetris> results = new ArrayList<>();
    Context context;

    public TetrisSearchResultsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TetrisSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tetris_item, parent, false);

        return new TetrisSearchResultHolder(itemView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TetrisSearchResultHolder holder, int position) {
        Tetris tetris = results.get(position);

        if (tetris.isHas_wiki()) {
            holder.container.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        } else {
            holder.container.setBackgroundColor(ContextCompat.getColor(context, R.color.white));

        }

        holder.titleTextView.setText(tetris.getName());
        holder.sizeTextView.setText(String.valueOf(tetris.getSize()));

        Owner owner = tetris.getOwner();
        if (owner != null) {
            String ownerName = owner.getLoginName();
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
        private CardView container;


        public TetrisSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.tetris_item_title);
            ownerTextView = itemView.findViewById(R.id.tetris_item_owner);
            sizeTextView = itemView.findViewById(R.id.tetris_item_size);
            container = itemView.findViewById(R.id.tetrisItemContainer);
        }
    }
}

