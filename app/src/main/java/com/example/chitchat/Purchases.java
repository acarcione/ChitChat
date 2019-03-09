package com.example.chitchat;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

public class Purchases
{
    //Keep Track of mtx user has bought; "Next-Word Reveals", background color options, font color options
    //Save info to local file

    //On first run, class should read the file and set values to an appropriate amount.

    private static Purchases instance;
    public static final String TAG = "Purchases";

    private Purchases() {}

    public static Purchases getInstance()
    {
        if (instance == null)
        {
            instance = new Purchases();
        }

        return instance;
    }


    public int numWordReveals = 0;
    HashMap<ElementColor, Boolean> unlockedFontColors = new HashMap<ElementColor, Boolean>();
    HashMap<ElementColor, Boolean> unlockedBackgroundColors = new HashMap<ElementColor, Boolean>();

    enum ElementColor
    {
        Yellow,
        Green,
        Red,
        Black,
        White
    }

    enum ItemType
    {
        Background,
        Font
    }

    //Set value of background/font color key in hashmap to true upon purchase
    public void setPurchase(ElementColor color, ItemType type, Context ct)
    {

        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();


        if (type.equals(ItemType.Background)){
            //Set background color
            unlockedBackgroundColors.put(color, true);
            editor.putBoolean("BACKGROUND " + color.toString(), unlockedBackgroundColors.get(color));
        }
        if (type.equals(ItemType.Font)){
            //Set font color
            unlockedFontColors.put(color, true);
            editor.putBoolean("FONT " + color.toString(), unlockedFontColors.get(color));
        }

        editor.apply();
    }

    public void updatePurchases(Context ct)
    {
        SharedPreferences saveData = ct.getSharedPreferences("Files", MODE_PRIVATE);

        for (ElementColor color : ElementColor.values())
        {
            //Update backgrounds
            String key = "BACKGROUND " + color.toString();
            String val = saveData.getString(key, null);
            if (val == null)
            {
                unlockedBackgroundColors.put(color, false);
            }
            else
            {
                unlockedBackgroundColors.put(color, Boolean.valueOf(val));
            }

            //Update fonts
            key = "FONT " + color.toString();
            val = saveData.getString(key, null);
            if (val == null)
            {
                unlockedFontColors.put(color, false);
            }
            else
            {
                unlockedFontColors.put(color, Boolean.valueOf(val));
            }
        }
    }

    //Decrement numWordReveals upon use
    public void useWordReveal(Context ct)
    {
        if (numWordReveals <= 0)
        {
            throw new IllegalStateException("Don't have any word reveals to use");
        }
        numWordReveals--;
        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();
        editor.putInt("numWordReveals", numWordReveals);
    }

    //Increment numWordReveals upon purchase
    public void purchaseWordReveal(Context ct)
    {
        numWordReveals++;
        SharedPreferences SaveData = ct.getSharedPreferences("Files", MODE_PRIVATE);
        SharedPreferences.Editor editor = SaveData.edit();
        editor.putInt("numWordReveals", numWordReveals);
    }

    public boolean isUnlocked(ItemType type, ElementColor color)
    {
        switch (type)
        {
            case Font:
                return unlockedFontColors.get(color);
            case Background:
                return unlockedBackgroundColors.get(color);
        }

        return false;
    }
}
