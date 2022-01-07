package com.example.csw_assignment1.Network;

import com.example.csw_assignment1.dto.MovieDto;
import com.example.csw_assignment1.dto.ResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String SERVER = "http://10.0.2.2:8081";

    @GET("/api/list")
    Call<ResponseDto> apiHome();
}
