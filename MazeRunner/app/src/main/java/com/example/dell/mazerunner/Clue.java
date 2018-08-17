package com.example.dell.mazerunner;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.Level;

public class Clue extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout l;
    TextView a;
    TextView b;
    levelone op=new levelone();
    leveltwo op2=new leveltwo();
    levelthree op3=new levelthree();
    levelfour op4=new levelfour();


    int index=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        l=(RelativeLayout) findViewById(R.id.LL);
        a=(TextView) findViewById(R.id.clueNo);
        b=(TextView) findViewById(R.id.clueStaement);
        a.setOnClickListener(this);
        b.setOnClickListener(this);


        if(levelcounter.level==2)
            a.setText("\nLEVEL II  ");
        if(levelcounter.level==3)
            a.setText("\nLEVEL III ");
        if(levelcounter.level==4)
            a.setText("\nLEVEL IV  ");

        b.setText("No. of clues cleared: " + levelcounter.count);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index==levelcounter.max+1)
                    index=1;

                if(levelcounter.level==1) {
                    op.Execute(index);
                    l.setBackgroundResource(levelone.c);

                }

                if(levelcounter.level==2) {


                    op2.Execute(index);
                    l.setBackgroundResource(leveltwo.c);

                }

                if(levelcounter.level==3) {

                    op3.Execute(index);
                    l.setBackgroundResource(levelthree.c);

                }

                if(levelcounter.level==4) {


                    op4.Execute(index);
                    l.setBackgroundResource(levelfour.c);

                }

                a.setText("");
                b.setText(" ");

            }
        });

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                levelcounter.text++;
                l.setBackgroundResource(R.drawable.black);
                a.setText(" CLUE" + index);
                if(levelcounter.level==1)
                b.setText(levelone.s);
                if(levelcounter.level==2)
                    b.setText(leveltwo.s);
                    if(levelcounter.level==3)
                        b.setText(levelthree.s);
                        if(levelcounter.level==4)
                            b.setText(levelfour.s);
                return  true;



            }
        });
    }






    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.LL) {
            Intent i = new Intent(Clue.this, MainActivity.class);

            startActivity(i);
        }





    }


}
