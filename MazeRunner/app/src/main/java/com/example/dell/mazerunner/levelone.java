package com.example.dell.mazerunner;

import android.widget.RelativeLayout;

/**
 * Created by dell on 9/20/2016.
 */
public class levelone {
   static int c=0;
    static int s=0;
    static boolean precedence[] = new boolean[5];






    void Execute(int p){

        switch(p){
            case 1:
                c=R.drawable.daigon;
                s=R.string.L1C1;
                break;
            case 2:
                    c=R.drawable.final_dumbledore;
                    s=R.string.L1C2;
                break;

            case 3:
                c=R.drawable.mcgonal_final;
                s=R.string.L1C3;
                break;

            case 4:
                c=R.drawable.hermoine;
                s=R.string.L1C4;
                break;


        }


    }
}
