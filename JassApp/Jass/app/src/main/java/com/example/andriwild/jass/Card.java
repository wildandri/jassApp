package com.example.andriwild.jass;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class Card {
    private int value;
    private int color;//0=herz, 1=ecke, 2=schaufel, 3=kreuz
    private int id;

    public Card (int value, int color, int id){
        this.color=color;
        this.value=value;
        this.id=id;
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
}
