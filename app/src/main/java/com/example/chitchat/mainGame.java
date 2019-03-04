package com.example.chitchat;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class mainGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Button button3 = (Button) findViewById(R.id.button3);

        final ImageView mainGameExample = (ImageView) findViewById(R.id.imageView_main_Game_Example);
        //final ImageView secondMainGameExample = (ImageView) findViewById(R.id.imageView_main_Game_Example2);
        Glide.with(mainGame.this)
                .load("https://miamiherald.typepad.com/.a/6a00d83451b26169e201bb081917f1970d-500wi")
                .into(mainGameExample);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(mainGame.this)
                        .load("https://sd.keepcalm-o-matic.co.uk/i/too-bad-so-sad-.png")
                        .into(mainGameExample);


            }
        });
    }
}





