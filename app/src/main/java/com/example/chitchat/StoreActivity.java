package com.example.chitchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class StoreActivity extends AppCompatActivity {

    private coin playerCountCount;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Button coinPurcahseButton = (Button)findViewById(R.id.coinPurchase);
        Button instantWordRevealButton = (Button)findViewById(R.id.instantWordReveal);
        Button newFontsButton = (Button)findViewById(R.id.newFonts);

       // SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();
       // mEditor.putInt("key", playerCoinCount);
        mEditor.commit();



    }


    public void coinPurchase(View view){
        Intent intent = new Intent(this, coinPurchase.class);
        startActivity(intent);
    }


    public void instantWordReveal(View view){
        Intent intent = new Intent(this, instantWordReveal.class);
        startActivity(intent);
    }

    public void newFonts(View view){
        Intent intent = new Intent(this, newFonts.class);
        startActivity(intent);
    }


}
