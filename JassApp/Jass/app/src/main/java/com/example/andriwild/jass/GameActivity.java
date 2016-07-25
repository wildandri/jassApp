package com.example.andriwild.jass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class GameActivity extends Activity {
    public GameLogic gl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gl=new GameLogic();
    }
    public void mix(View v){
        gl.mix();
    }
}
