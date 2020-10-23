package com.example.graduiation.ui.Data;

import com.example.graduiation.ui.LegacyData.PaymentModel;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IMatba5Api {

    @POST("addMeal")
    Observable<MealModel> addMeal(@HeaderMap HashMap<String,String> token, @Body MealModel mealModel);
    @GET("getUsersInCategory")
    Observable<ArrayList<UserModel>> getUsersInCategory(@Query("category") String category , @Query("page") int page, @HeaderMap HashMap<String, String> token);

}
