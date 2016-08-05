package com.example.andriwild.jass;

import android.util.Log;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class Player {

    private int id;
    public String name;
    private int points=0;
    public int[] numbers;

    public Player (String name,int id){
        this.name=name;
        this.id=id;
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

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }
    public void increasePoints(int points){
        this.points+=points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

}
