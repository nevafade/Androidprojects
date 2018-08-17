package com.example.dell.mazerunner;

/**
 * Created by dell on 9/20/2016.
 */
public class leveltwo{

    static int c=0;
    static int s=0;
    static boolean precedence[] = new boolean[4];





    void Execute(int p){
        switch(p){
            case 1:
                c=R.drawable.batmobile;
                s=R.string.L2C1;
                break;
            case 2:
                c=R.drawable.joker;
                s=R.string.L2C2;
                break;

            case 3:
                c=R.drawable.twofaced;
                s=R.string.L2C3;
                break;




        }


    }
}
