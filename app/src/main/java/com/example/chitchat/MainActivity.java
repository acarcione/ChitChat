package com.example.chitchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView exampleImage = findViewById(R.id.imageView_main_activity_example);
        //TODO: Delete this --- Glide example
        Glide.with(this)
                .load(R.drawable.horse) //If app has internet permissions, you can use URL here
                .centerCrop()
                .into(exampleImage);
    }
}
