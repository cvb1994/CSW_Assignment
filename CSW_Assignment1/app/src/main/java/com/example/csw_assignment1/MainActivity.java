package com.example.csw_assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.csw_assignment1.Adapter.MovieAdapter;
import com.example.csw_assignment1.Adapter.SectionAdapter;
import com.example.csw_assignment1.Model.Movie;
import com.example.csw_assignment1.Network.ApiManager;
import com.example.csw_assignment1.dto.MovieDto;
import com.example.csw_assignment1.dto.ResponseDto;
import com.example.csw_assignment1.dto.Section;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<MovieDto> listMovie = new ArrayList<>();
    List<Section> listSection = new ArrayList<>();
    CarouselView carouselView;
    RecyclerView rvHome;
    SectionAdapter sectionAdapter;

    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCarouselView();
        initRecyclerView();
        initData();

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    private void initRecyclerView() {
//        for (int i = 0; i < 10; i++) {
//            MovieDto model = new MovieDto("Movie "+ i, 0);
//            listMovie.add(model);
//        }
        //B2: Adapter
        sectionAdapter = new SectionAdapter(this, listSection);

        //B3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //B4: RecyclerView
        rvHome = findViewById(R.id.rvHome);
        rvHome.setLayoutManager(layoutManager);
        rvHome.setHasFixedSize(true);
        rvHome.setAdapter(sectionAdapter);
    }

    private void initCarouselView() {
        CarouselView carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        };
        carouselView.setImageListener(imageListener);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "Clicked item: "+ position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiManager service = retrofit.create(ApiManager.class);
        service.apiHome().enqueue(new Callback<ResponseDto>() {

            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                Log.d("TAG", "onResponse: ");
                List<MovieDto> trending = (List<MovieDto>) response.body().getTrending();
                if(trending != null){
                    listSection.add(new Section("Trending", trending,
                            new MovieAdapter(trending,MainActivity.this)));
                }
                List<MovieDto> top = (List<MovieDto>) response.body().getTop();
                if(top != null){
                    listSection.add(new Section("Hot", top,
                            new MovieAdapter(top,MainActivity.this)));
                }
                sectionAdapter.reloadData(listSection);

            }

            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t);
            }
        });
    }
}