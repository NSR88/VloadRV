package com.vload.ex;

import com.vload.ex.pojo.Terms_condition_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
//https://www.googleapis.com/youtube/v3/search?part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs
public interface ApiInterface {
//    @GET("/youtube/v3/search")
//    Call<RoyListItems> getTopRatedMovies(@Query("part") String part, @Query("maxResults") String maxResults, @Query("channelId") String channelId, @Query("key") String key);


    @GET("/mobile/terms_of_use.php")
    Call<List<Terms_condition_Model>> getTermsConditions();
 
}