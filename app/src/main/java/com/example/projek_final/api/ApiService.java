package com.example.projek_final.api;

import com.example.projek_final.model.FoodModel;
import com.example.projek_final.responses.FoodResponses;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    String RAPID_API_KEY = "93181b98d6mshf93653b16bf5cbcp1da356jsnf7b6c9615a0b";
    String RAPID_API_HOST = "edamam-food-and-grocery-database.p.rapidapi.com";

    @Headers({
            "X-RapidAPI-Key: " + RAPID_API_KEY,
            "X-RapidAPI-Host: " + RAPID_API_HOST
    })


    @GET("api/food-database/v2/parser")
    Call<FoodResponses> getFood(

    );
}
