package com.example.chitchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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
        EditText editText2 = (EditText)findViewById(R.id.EditText2);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

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
        Intent startNewActivity = new Intent(this, startGame.class);
        startActivity(startNewActivity);

    }

    public void newWord(View view){

    }


}
