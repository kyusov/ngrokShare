package ru.isu.math.yusov.myfirstapp;

import retrofit2.Call;
import retrofit2.http.*;
import ru.isu.math.yusov.myfirstapp.model.Profile;

import java.util.List;

public interface ProfileService {
    @GET("/profiles")
    Call<List<Profile>> profile();

    @POST("/profiles")
    Call<Profile> addProfile(@Body Profile p);

    @DELETE("/profiles/{id}")
    Call<Profile> deleteProfile(@Path("id") Integer id);
}
