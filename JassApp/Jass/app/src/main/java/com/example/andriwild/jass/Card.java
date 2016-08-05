package com.example.andriwild.jass;

import android.util.Log;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class Card {
    private int value;
    private int color;//0=herz, 1=ecke, 2=schaufel, 3=kreuz
    private int id;//0=6, 1=7, 2=8, 3=9, 4=10, 5=Bauer, 6=Dame, 7=Koenig, 8=ASS


    private boolean playable;

    public Card (int value, int color, int id){
        this.color=color;
        this.value=value;
        this.id=id;
        playable = true;

        Log.d("color",""+color);
        Log.d("value",""+value);
        Log.d("id",""+id);
    }
    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

}
