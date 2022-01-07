package com.example.csw_assignment1.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.csw_assignment1.DetailActivity;
import com.example.csw_assignment1.MainActivity;
import com.example.csw_assignment1.Model.Movie;
import com.example.csw_assignment1.R;
import com.example.csw_assignment1.dto.MovieDto;

import java.util.List;

public class MovieAdapter  extends RecyclerView.Adapter{
    private List<MovieDto> listMovie;
    private Activity activity;
    private String sectionTitle;

    public MovieAdapter(List<MovieDto> list, Activity activity) {
        this.listMovie = list;
        this.activity = activity;
    }

    public MovieAdapter(List<MovieDto> list) {
        this.listMovie = list;
    }

    public void reloadData(List<MovieDto> list) {
        this.listMovie = list;
        this.notifyDataSetChanged();
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
        if (sectionTitle.equalsIgnoreCase("Hot")) {
            itemView = ((Activity) parent.getContext()).getLayoutInflater().inflate(R.layout.item_movie2, parent, false);
        } else {
            itemView = ((Activity) parent.getContext()).getLayoutInflater().inflate(R.layout.item_movie, parent, false);
        }
        MovieHolder holder = new MovieHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MovieDto model = listMovie.get(position);
        MovieHolder vh = (MovieHolder) holder;

        vh.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                MovieDto movie = listMovie.get(position);
                Intent intent = new Intent(activity, DetailActivity.class);
                intent.putExtra("img",movie.getThumbnail());
                intent.putExtra("des",movie.getDescription());
                intent.putExtra("name",movie.getName());
                activity.startActivity(intent);
            }
        });
        vh.tvTitle.setText(model.getName());
        Glide.with(activity).load(model.getThumbnail()).into(vh.ivCover);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        private ItemClickListener itemClickListener;

        ImageView ivCover;
        TextView tvTitle;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivCover);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}
