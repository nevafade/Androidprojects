package com.example.dell.mazerunner;

/**
 * Created by dell on 9/20/2016.
 */
public class levelcounter {
    static int level = 0;
    static int count = 0;
    static int max = 0;
    static int text=0;

    void execute() {
        if (level == 1)
            max = 4;

        if (level == 2)
            max = 3;

        if (level == 3)
            max = 4;

        if (level == 4)
            max = 2;

    }

}
