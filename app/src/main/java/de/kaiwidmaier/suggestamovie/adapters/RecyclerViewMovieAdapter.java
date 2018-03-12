package de.kaiwidmaier.suggestamovie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.kaiwidmaier.suggestamovie.R;
import de.kaiwidmaier.suggestamovie.data.Movie;

/**
 * Created by Kai on 12.03.2018.
 */

public class RecyclerViewMovieAdapter extends RecyclerView.Adapter<RecyclerViewMovieAdapter.ViewHolder> {


  private static final String TAG = RecyclerViewMovieAdapter.class.getSimpleName();
  private List<Movie> movies;
  private LayoutInflater inflater;
  private final String imgUrlBasePath ="http://image.tmdb.org/t/p/w500//";
  private RecyclerViewMovieAdapter.ItemClickListener clickListener;
  private Context context;


  public RecyclerViewMovieAdapter(Context context, List<Movie> movies) {
    this.inflater = LayoutInflater.from(context);
    this.movies = movies;
    this.context = context;
  }


  @Override
  public RecyclerViewMovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.recyclerview_movie_item, parent, false);
    RecyclerViewMovieAdapter.ViewHolder viewHolder = new RecyclerViewMovieAdapter.ViewHolder(view);
    return viewHolder;
  }


  @Override
  public void onBindViewHolder(RecyclerViewMovieAdapter.ViewHolder holder, int position) {
    final Movie movie = movies.get(position);
    if(movie.getPosterPath() != null) {
      String posterUrl = imgUrlBasePath + movie.getPosterPath();
      Log.d(TAG, "Poster URL " + movie.getTitle() + ": " + posterUrl);
      Picasso.with(context).load(posterUrl).placeholder(R.drawable.placeholder_thumbnail).error(R.drawable.placeholder_thumbnail).into(holder.thumbnail);
      holder.title.setText(movie.getTitle());
    }
  }


  @Override
  public int getItemCount() {
    return movies.size();
  }


  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView thumbnail;
    TextView title;

    public ViewHolder(View itemView) {
      super(itemView);
      thumbnail = itemView.findViewById(R.id.img_thumbnail_movie_recycler);
      title = itemView.findViewById(R.id.text_movie_title_recycler);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      if (clickListener != null) clickListener.onItemClick(view, getAdapterPosition());
    }
  }


  public Movie getItem(int id) {
    return movies.get(id);
  }

  public void setClickListener(RecyclerViewMovieAdapter.ItemClickListener itemClickListener) {
    this.clickListener = itemClickListener;
  }


  public interface ItemClickListener {
    void onItemClick(View view, int position);
  }

}
