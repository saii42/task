package com.example.movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitAPI {
   @Headers({
           "X-Naver-Client-Id:NzjlPieyFExVOmB3pTMs",
           "X-Naver-Client-Secret:yBqjGqHAEL"
   })

   @GET("v1/search/movie.json")
   Call<MovieData> getMovieData (@Query("query") String movie) ;
}
