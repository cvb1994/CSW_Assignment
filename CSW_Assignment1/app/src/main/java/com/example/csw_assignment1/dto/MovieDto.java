package com.example.csw_assignment1.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDto {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("category")
    @Expose
    private CategoryDto category;
    @SerializedName("director")
    @Expose
    private DirectorDto director;

    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public MovieDto(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public DirectorDto getDirector() {
        return director;
    }

    public void setDirector(DirectorDto director) {
        this.director = director;
    }
}
