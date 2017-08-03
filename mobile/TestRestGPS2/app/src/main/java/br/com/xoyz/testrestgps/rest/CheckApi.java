package br.com.xoyz.testrestgps.rest;

import java.util.List;

import br.com.xoyz.testrestgps.entity.Check;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lelag on 01/08/2017.
 */

public interface CheckApi {

    public static final String URL_CHECK ="http://10.0.2.2:8080/check/";

    // get json list of checks
    @GET("/check/find")
    Call<List<Check>> find(@Query("page") int page, @Query("size") int size);

    // updating the position from a check
    @FormUrlEncoded
    @POST("/check/checkin")
    Call<Check> checkin(@Field("latLng") String latLng, @Field("venueName") String venueName, @Field("id") String id);

    @FormUrlEncoded
    @POST("/check/checkout")
    Call<Check> checkout(@Field("id") String id);
}
