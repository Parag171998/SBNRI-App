package com.example.paragranesbnri.Network;

import com.example.paragranesbnri.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("repos?per_page=10")
    Call<List<User>> getUsersList(@Query("page") String no);


}
