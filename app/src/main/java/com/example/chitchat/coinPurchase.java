package com.example.chitchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class coinPurchase extends AppCompatActivity {

    private coin playerCoinCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_purchase);


        Button tenbutton = (Button)findViewById(R.id.tenbutton);
        Button hunderdbutton = (Button)findViewById(R.id.hunderdbutton);
        Button thousandbutton = (Button)findViewById(R.id.thousandbutton);

        tenbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerCoinCount.addCoin(10);

            }
        });
        hunderdbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerCoinCount.addCoin(100);

            }
        });
        thousandbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerCoinCount.addCoin(1000);

            }
        });






    }
}
