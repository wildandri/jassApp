package com.example.andriwild.jass;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Andri Wild on 05.08.2016.
 */
public class PlayerActivity extends Activity{
    RelativeLayout layout;
    ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        ImageView secondImage = (ImageView)findViewById(R.id.imageViewCard2);
        secondImage.setImageResource(R.drawable.herz1);
        mainImage = (ImageView) findViewById(R.id.imageViewCard1);
        mainImage.setImageResource(R.drawable.herz0);
        layout =(RelativeLayout)findViewById(R.id.layout);


    }
public void matrix (View v){
    int height=layout.getHeight();
    int width=layout.getWidth();
    Matrix m1=mainImage.getImageMatrix();
    Log.d("W: ", "" + width);
    Log.d("H: ", "" + height);
    m1.setRotate(30,height/2,width/2);
    m1.postTranslate(width / 20, height / 20);




    mainImage.setImageMatrix(m1);

    mainImage.invalidate();

    //mainImage.setRotation(50);

}

}
