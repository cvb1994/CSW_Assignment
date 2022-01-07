package com.example.csw_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;

public class DetailActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tvname, tvDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv = findViewById(R.id.ivCover);
        tvname = findViewById(R.id.name);
        tvDes = findViewById(R.id.des);

        Intent intent = getIntent();
        String image = intent.getStringExtra("img");
        Glide.with(this).load(image).into(iv);
        tvname.setText(intent.getStringExtra("name"));
        tvDes.setText(intent.getStringExtra("des"));
    }
}
