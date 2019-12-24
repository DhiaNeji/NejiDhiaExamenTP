package com.example.nejidhiaexamentp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiHandler {
    @FormUrlEncoded
    @POST("insert")
    Call<Personnel>insert(@Field("Matricule") String Matricule,
                          @Field("Nom") String Nom,
                          @Field("Diplome") String Diplome
                          );
}