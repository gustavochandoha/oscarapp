package com.example.oscarapp.helper;

import com.example.oscarapp.model.Diretor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("/ufpr/diretor")
    Call<List<Diretor>> getDiretor();
}
