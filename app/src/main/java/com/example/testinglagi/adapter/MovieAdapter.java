package com.example.testinglagi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testinglagi.R;
import com.example.testinglagi.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movies){
        this.context = context;
        movieList = movies;
    }
    @NonNull
    @Override
    public MovieAdapter.MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle().toString());
        holder.desc.setText(movie.getOverview());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPoster()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView title, desc;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movieImage);
            title = itemView.findViewById(R.id.movieTitle);
            desc = itemView.findViewById(R.id.movieDesc);

        }
    }
}
