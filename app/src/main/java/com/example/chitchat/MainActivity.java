package com.example.chitchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView exampleImage = findViewById(R.id.imageView_main_activity_example);


           //TODO: Delete this --- Glide example
           // Glide.with(this)
           //     .load(R.drawable.horse) //If app has internet permissions, you can use URL here
            //    .centerCrop()
             //   .into(exampleImage);


        final EditText editText1 = (EditText)findViewById(R.id.EditText1);
        final EditText editText2 = (EditText)findViewById(R.id.EditText2);
        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);






       // button1.setOnClickListener(play);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] myStringArray = new String[23];
                for(int i = 0; i < myStringArray.length; i++){
                    myStringArray[i] = "a";
                    editText1.setText(myStringArray[i]);

                }

            }
        });

    }




    public void startGame(View view){

    }


    public void newWord(View view){

    }

}
