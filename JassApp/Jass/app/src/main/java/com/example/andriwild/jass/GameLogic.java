package com.example.andriwild.jass;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Andri Wild on 25.07.2016.
 */
public class GameLogic {
    ArrayList<Card> cards;
    Player a,b,c,d;
    private int gameID;
    private int roundNumber;

    public GameLogic(){
        a=new Player("a");
        b=new Player("b");
        c=new Player("c");
        d=new Player("d");
        gameID = 0;
        roundNumber=0;
        cards=new ArrayList<Card>();
        for(int i=0;i<4;i++){
            for (int j=0;j<9;j++){
                cards.add(new Card(j,i,j));
            }
        }
    }

    public void mix(){
        Random rand=new Random();
        int index=0;
        int[] numbers=new int[36];
        while(index<36){
            int n=rand.nextInt(36);
            numbers[index]=n;
            int point=0;
            for(int i:numbers){
                if(i==n && index==point){
                    index++;
                    break;
                }
                if(i==n){
                    break;
                }
                point++;
            }
        }

        int[] a = new int[9];
        int[] b = new int[9];
        int[] c = new int[9];
        int[] d = new int[9];

        System.arraycopy(numbers,0,a,0,a.length);
        System.arraycopy(numbers,a.length,b,0,b.length);
        System.arraycopy(numbers,a.length*2,c,0,c.length);
        System.arraycopy(numbers,a.length*3,d,0,d.length);
        this.a.setNumbers(a);
        this.b.setNumbers(b);
        this.c.setNumbers(c);
        this.d.setNumbers(d);
    }

    public void gamePlay (int [] cardNumbers){
        switch (gameID){
            case 0: compare(0, cardNumbers);
                break;
            case 1: compare(1, cardNumbers);
                break;
            case 2: compare(2, cardNumbers);
                break;
            case 3: compare(3, cardNumbers);
                break;
            case 4: compare(4, cardNumbers);//oben
                break;
            case 5:compare(5, cardNumbers);//unten
                break;
            case 6:compare(6, cardNumbers);
                gameID=7;
                setValue();
                break;
            case 7:compare(7, cardNumbers);
                resetValue();
                gameID=6;
                break;
        }
    }
    public void compare(int gameID,int [] cardNumbers){
        int highest=-1;
        int idHighest=0;
        int playerHighest=0;
        int iteration=0;
        if(gameID<4) {
            for (int i : cardNumbers) {
                if (cards.get(i).getColor() == gameID) {
                    if (cards.get(i).getValue() > highest) {
                        Log.d("current highest", ""+cards.get(i).getValue());
                        highest = cards.get(i).getValue();
                        idHighest = i;
                        playerHighest = iteration;
                    }
                }
                iteration++;
            }
            if (highest > -1) {
                Log.d("id Highest",Integer.toString(idHighest));
                Log.d("Highest color",Integer.toString(cards.get(idHighest).getColor()));
                Log.d("Highest ID",Integer.toString(cards.get(idHighest).getId()));
                return;
            }
        }

        int firstColor=cards.get(cardNumbers[0]).getColor();
        highest=cards.get(cardNumbers[0]).getValue();
        Log.d("First highest",""+highest);
        idHighest=cardNumbers[0];
        for(int i=1;i<cardNumbers.length;i++){
            if(cards.get(cardNumbers[i]).getColor()==firstColor){
                if(cards.get(cardNumbers[i]).getValue()>highest){
                    highest=cards.get(cardNumbers[i]).getValue();
                    idHighest=cardNumbers[i];
                    playerHighest=i;
                }
            }
        }
        Log.d("id Highest",Integer.toString(idHighest));
        Log.d("Highest color",Integer.toString(cards.get(idHighest).getColor()));
        Log.d("Highest ID",Integer.toString(cards.get(idHighest).getId()));
        return;

    }
    public void setValue(){
        if(gameID<4){
            cards.get(gameID * 9 + 5).setValue(10);
            cards.get(gameID * 9 + 3).setValue(9);
            Log.d("Value Bauer", ""+cards.get(gameID*9+5).getValue());
        }
        if(gameID==5 || gameID == 7){
            for(int i=0;i<4;i++){
                int value=8;
                for (int j=0;j<9;j++){
                    cards.get(i*9+j).setValue(value);
                    value--;
                }
            }
        }
    }
    public void resetValue(){
       for(int i=0;i<4;i++){
           for (int j=0;j<9;j++){
               cards.get(i*9+j).setValue(j);
                }
            }
    }
    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }


}
