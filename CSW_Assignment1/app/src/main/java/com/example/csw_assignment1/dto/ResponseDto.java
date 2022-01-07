package com.example.csw_assignment1.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ResponseDto {
    @SerializedName("name")
    @Expose
    private String message;

    @SerializedName("trending")
    @Expose
    private List<MovieDto> trending;

    @SerializedName("top")
    @Expose
    private List<MovieDto> top;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MovieDto> getTrending() {
        return trending;
    }

    public void setTrending(List<MovieDto> trending) {
        this.trending = trending;
    }

    public List<MovieDto> getTop() {
        return top;
    }

    public void setTop(List<MovieDto> top) {
        this.top = top;
    }
}
