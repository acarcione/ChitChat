package com.example.chitchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newFonts extends AppCompatActivity {


    private coin playerCoinCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fonts);


        Button blue = (Button)findViewById(R.id.blue);
        Button yellow = (Button)findViewById(R.id.yellow);
        Button red = (Button)findViewById(R.id.red);

        blue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerCoinCount.subtractCoin(1);

            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerCoinCount.subtractCoin(100);

            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerCoinCount.subtractCoin(1000);


            }
        });

    }
}
