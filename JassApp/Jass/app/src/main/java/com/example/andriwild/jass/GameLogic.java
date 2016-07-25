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
    int gameID;
    public GameLogic(){
        a=new Player("a");
        b=new Player("b");
        c=new Player("c");
        d=new Player("d");
        gameID = 0;
        cards=new ArrayList<Card>();
        int m=0;
        for(int i=0;i<4;i++){
            for (int j=0;j<9;j++){
                cards.add(new Card(j,i,m));
                m++;
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

    public void gamePlay (int gameID,int [] cardNumbers){
        switch (gameID){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }
    public void compare(int gameID,int [] cardNumbers){
        int highest=-1;
        int idHighest=0;
        int playerHighest=0;
        int iteration=0;
        if(gameID<4){
        for(int i:cardNumbers){
            if(cards.get(i).getColor()==gameID){
                if(cards.get(i).getValue()>highest){
                    highest=cards.get(i).getValue();
                    idHighest=i;
                    playerHighest=iteration;
                }
            }
            iteration++;
        }
        if(highest>-1){
            return;
        }
        }
        int firstColor=cards.get(cardNumbers[0]).getColor();
        highest=cards.get(cardNumbers[0]).getValue();
        for(int i=1;i<cardNumbers.length;i++){
            if(cards.get(cardNumbers[i]).getColor()==firstColor){
                if(cards.get(cardNumbers[i]).getValue()>highest){
                    highest=cards.get(cardNumbers[i]).getValue();
                    idHighest=cardNumbers[i];
                    playerHighest=i;
                }
            }
            if(true){
                Log.d("Daniel","Andri");
            }
        }



    }
    public void setValue(){

    }



}
