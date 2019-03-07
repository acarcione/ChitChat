package com.example.chitchat;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;

public class Purchases {
    //Keep Track of mtx user has bought; "Next-Word Reveals", background color options, font color options
    //Save info to local file

    //On first run, class should read the file and set values to an appropriate amount.


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
        }
        if (type.equals("Font")){
            //Set font color
            unlockedFontColors.put(color, true);
        }

        for (elementColor c : unlockedBackgroundColors.keySet()) {
            editor.putBoolean("BACKGROUND " + c.toString(), unlockedBackgroundColors.get(c));
        }
        for (elementColor c : unlockedFontColors.keySet()) {
            editor.putBoolean("FONT " + c.toString(), unlockedFontColors.get(c));
        }
    }

    //Decrement numWordReveals upon use
    public void useWordReveal(Context ct){
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

    /*
    //Save info to local file
    public SharedPreferences getSharedPreferences (Context ctxt) {
        SharedPreferences SaveData = ctxt.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();

        //editor.putString("Background Options", unlockedBackgroundColors.toString());
        //editor.putString("Font Options", unlockedFontColors.toString());
        //editor.putString("Num Word Reveals", Integer.toString(numWordReveals));

        editor.putBoolean(elementColor.yellow.toString(), false);
        editor.putBoolean(elementColor.green.toString(), false);
        editor.putBoolean(elementColor.red.toString(), false);
        return SaveData;
    }


    public static void main(String[] args) {

    }
    */
}
