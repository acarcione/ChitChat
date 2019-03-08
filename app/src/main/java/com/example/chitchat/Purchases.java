package com.example.chitchat;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import android.preference.PreferenceManager;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class Purchases
{
    //Keep Track of mtx user has bought; "Next-Word Reveals", background color options, font color options
    //Save info to local file

    //On first run, class should read the file and set values to an appropriate amount.

    public static final String TAG = "Purchases";


    public int numWordReveals = 0;
    HashMap<elementColor, Boolean> unlockedFontColors = new HashMap<elementColor, Boolean>();
    HashMap<elementColor, Boolean> unlockedBackgroundColors = new HashMap<elementColor, Boolean>();

    enum elementColor{
        yellow,
        green,
        red
    }

    //Set value of background/font color key in hashmap to true upon purchase
    public void setPurchase(elementColor color, String type, Context ct){

        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();


        if (type.equals("Background")){
            //Set background color
            unlockedBackgroundColors.put(color, true);
            editor.putBoolean("BACKGROUND " + color.toString(), unlockedBackgroundColors.get(color));
        }
        if (type.equals("Font")){
            //Set font color
            unlockedFontColors.put(color, true);
            editor.putBoolean("FONT " + color.toString(), unlockedFontColors.get(color));

        }
    }

    public void updatePurchase(Context ct){
        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        Map<String, ?> map = SaveData.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] splited = key.split("\\s+");

            elementColor color = elementColor.valueOf(splited[1]); // First Word is either BACKGROUND or FONT. Want to only append color.
            Boolean value = Boolean.parseBoolean(entry.getValue().toString());

            if (splited[0].equals("BACKGROUND")){
                //Update backgrounds
                unlockedBackgroundColors.put(color, value);
            }
            else{
                //Update fonts
                unlockedFontColors.put(color, value);
            }
        }
    }

    //Decrement numWordReveals upon use
    public void useWordReveal(Context ct){
        if (numWordReveals <= 0){
            Log.d(TAG, "Error"); //Should throw error instead maybe
            return;
        }
        numWordReveals--;
        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();
        editor.putInt("numWordReveals", numWordReveals);
    }

    //Increment numWordReveals upon purchase
    public void purchaseWordReveal(Context ct){
        numWordReveals++;
        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();
        editor.putInt("numWordReveals", numWordReveals);
    }
}
