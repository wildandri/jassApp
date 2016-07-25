package com.example.andriwild.jass;

import android.util.Log;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class Player {
    public int id;
    public String name;

    public int[] numbers;
    public Player (String name){
        this.name=name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
        for (int i:this.numbers){
            Log.d(name, "" + i);
        }
    }

}
