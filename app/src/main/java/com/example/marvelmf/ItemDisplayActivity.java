package com.example.marvelmf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ItemDisplayActivity extends AppCompatActivity {
    String image_url;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);
        imageView = findViewById(R.id.imageView);
        //getting passed data
        Intent intent = getIntent();
        image_url = intent.getStringExtra("imageurl");


        Glide.with(this)
                .load(image_url)
                .into(imageView);
    }
}