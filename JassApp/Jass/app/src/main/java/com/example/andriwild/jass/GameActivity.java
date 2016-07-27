package com.example.andriwild.jass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class GameActivity extends Activity {
    public GameLogic gl;
    private Spinner spinnerPlayer1,spinnerPlayer2, spinnerPlayer3,spinnerPlayer4;
    List<String> spinnerArrayPlayer1, spinnerArrayPlayer2, spinnerArrayPlayer3, spinnerArrayPlayer4;
    ArrayAdapter<String> dataAdapterPlayer1, dataAdapterPlayer2, dataAdapterPlayer3, dataAdapterPlayer4;
    String selectedItemPlayer1, selectedItemPlayer2, selectedItemPlayer3, selectedItemPlayer4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gl=new GameLogic();

        spinnerArrayPlayer1 = new ArrayList<String>();
        spinnerArrayPlayer2 = new ArrayList<String>();
        spinnerArrayPlayer3 = new ArrayList<String>();
        spinnerArrayPlayer4 = new ArrayList<String>();

        spinnerPlayer1 = (Spinner) findViewById(R.id.spinner);
        spinnerPlayer2 = (Spinner) findViewById(R.id.spinner2);
        spinnerPlayer3 = (Spinner) findViewById(R.id.spinner3);
        spinnerPlayer4 = (Spinner) findViewById(R.id.spinner4);

        dataAdapterPlayer1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArrayPlayer1);
        dataAdapterPlayer2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArrayPlayer2);
        dataAdapterPlayer3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArrayPlayer3);
        dataAdapterPlayer4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArrayPlayer4);

        dataAdapterPlayer1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterPlayer2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterPlayer3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterPlayer4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlayer1.setAdapter(dataAdapterPlayer1);
        spinnerPlayer2.setAdapter(dataAdapterPlayer2);
        spinnerPlayer3.setAdapter(dataAdapterPlayer3);
        spinnerPlayer4.setAdapter(dataAdapterPlayer4);

        spinnerPlayer1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long myID) {
                selectedItemPlayer1 = parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerPlayer2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long myID) {
                selectedItemPlayer2 = parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerPlayer3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long myID) {
                selectedItemPlayer3 = parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerPlayer4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long myID) {
                selectedItemPlayer4 = parentView.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void mix(View v){
        gl.mix();
        addItems(gl.a.getNumbers(),dataAdapterPlayer1);
        addItems(gl.b.getNumbers(),dataAdapterPlayer2);
        addItems(gl.c.getNumbers(),dataAdapterPlayer3);
        addItems(gl.d.getNumbers(),dataAdapterPlayer4);

    }
    public void test(View v){
        removeItem(dataAdapterPlayer1,selectedItemPlayer1);
        removeItem(dataAdapterPlayer2,selectedItemPlayer2);
        removeItem(dataAdapterPlayer3,selectedItemPlayer3);
        removeItem(dataAdapterPlayer4,selectedItemPlayer4);
    }
    public void addItems(int[] cards, ArrayAdapter<String> spinnerArrayAdapter){
        for(int i:cards){
            spinnerArrayAdapter.add(Integer.toString(i));
        }
        spinnerArrayAdapter.notifyDataSetChanged();
    }
    public void removeItem(ArrayAdapter<String> spinnerArrayAdapter, String item){
        if(item!=null){
            spinnerArrayAdapter.remove(item);
        }
    }

}
