package base.api;

import com.br.themoviedbkleyton.home.model.GenreAndMoviesResponse;
import com.br.themoviedbkleyton.home.model.GenreResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kleyton on 15/01/18.
 */

public interface ServiceApi {

    @GET("/3/genre/movie/list")
    Call<GenreResponse> getGenre(@Query("api_key") String apiKey, @Query("language") String language);


    @GET("/3/movie/{movie_id}/similar")
    Call<GenreAndMoviesResponse> getSimilarMovie(@Path("movie_id") String movieId,
                                                 @Query("api_key") String apiKey,
                                                 @Query("language") String language,
                                                 @Query("sort_by") String page
    );

    @GET("/3/genre/{genre_id}/movies")
    Call<GenreAndMoviesResponse> getMoviesByGenre(@Path("genre_id") String genreId,
                                                  @Query("api_key") String apiKey,
                                                  @Query("language") String language,
                                                  @Query("include_adult") String includeAdult,
                                                  @Query("sort_by") String sortBy
    );

    @GET("/3/search/movie")
    Call<GenreAndMoviesResponse> searchMovie(@Query("api_key") String  apiKey,
                              @Query("language") String language,
                              @Query("include_adult") String includeAdult,
                              @Query("query") String query
    );

}
