package com.example.dell.mazerunner;

import android.widget.Toast;

/**
 * Created by dell on 9/20/2016.
 */
public class levelfour {
    static int c=0;
    static int s=0;
    static boolean precedence[] = new boolean[3];






    void Execute(int p) {
        switch (p) {
            case 1:
                c = R.drawable.sherlock2;
                s = R.string.L4C1;
                break;
            case 2:
                c = R.drawable.sherlock;
                s = R.string.L4C1;
                break;
        }
    }

}
