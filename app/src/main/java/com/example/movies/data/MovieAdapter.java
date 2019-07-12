package com.example.movies.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movies.R;
import com.example.movies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        TextView yearTextView;
        ImageView posterImageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            posterImageView = itemView.findViewById(R.id.posterImageView);
        }
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {

        Movie currentMovie = movies.get(i);
        String title = currentMovie.getTitle();
        String year = currentMovie.getYear();
        String posterUrl = currentMovie.getPosterUrl();
        movieViewHolder.titleTextView.setText(title);
        movieViewHolder.yearTextView.setText(year);
        Picasso.get().load(posterUrl).centerInside()
                .into(movieViewHolder.posterImageView);
    }



    @Override
    public int getItemCount() {
        return movies.size();
    }
}
