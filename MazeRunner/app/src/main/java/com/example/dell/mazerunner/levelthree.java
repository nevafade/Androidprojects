package com.example.dell.mazerunner;

/**
 * Created by dell on 9/20/2016.
 */
public class levelthree {

    static int c=0;
    static int s=0;
    static boolean precedence[] = new boolean[5];





    void Execute(int p){
        switch(p){
            case 1:
                c=R.drawable.phebes;
                s=R.string.L3C1;
                break;
            case 2:
                c=R.drawable.monica;
                s=R.string.L3C2;
                break;

            case 3:
                c=R.drawable.frame;
                s=R.string.L3C3;
                break;

            case 4:
                c=R.drawable.joey;
                s=R.string.L3C4;
                break;


        }


    }
}
