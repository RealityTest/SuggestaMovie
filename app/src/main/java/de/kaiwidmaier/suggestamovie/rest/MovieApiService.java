package de.kaiwidmaier.suggestamovie.rest;

import de.kaiwidmaier.suggestamovie.data.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Kai on 04.03.2018.
 */

public interface MovieApiService {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovies(@Query("api_key") String apiKey, @Query("language") String language, @Query("region") String region);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey, @Query("language") String language, @Query("region") String region);

}
