package com.example.dell.dicegame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView dice_face;
    TextView Player,p0,p1;
    Button Rolldice,Holddice,Resetdice;
    int presentface=1;
    int faceid=0;
    int turn =0;
    int player0=0;
    int player1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dice_face=(ImageView) findViewById(R.id.dice_face);
        Rolldice=(Button) findViewById(R.id.roll_button);
        Holddice=(Button) findViewById(R.id.hold_button);
        Resetdice=(Button) findViewById(R.id.reset_button);
        Player=(TextView) findViewById(R.id.player);
        p0=(TextView) findViewById(R.id.firstplayerscore);
        p1=(TextView) findViewById(R.id.secondplayerscore);
        final Random t=new Random();

        Holddice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hold();
            }
        });


        Resetdice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        Rolldice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentface=t.nextInt(6);
                if(presentface==0) {
                    faceid = R.mipmap.ic_dice_one;
                    if(turn==0)
                        player0=0;
                    else
                        player1=0;
                }
                if(presentface==1) {
                    faceid = R.mipmap.ic_dice_one;
                    if(turn==0)
                        player0=0;
                    else
                        player1=0;
                }
                if(presentface==2) {
                    faceid = R.mipmap.ic_dice_two;
                    if(turn==0)
                        player0=player0+2;
                    else
                        player1=player1+2;
                }
                if(presentface==3)
                {
                    faceid = R.mipmap.ic_dice_three;
                    if(turn==0)
                        player0=player0+3;
                    else
                        player1=player1+3;
                }
                if(presentface==4)
                {
                    faceid = R.mipmap.ic_dice_four;
                    if(turn==0)
                        player0=player0+4;
                    else
                        player1=player1+4;
                }
                if(presentface==5)
                {
                    faceid = R.mipmap.ic_dice_five;
                    if(turn==0)
                        player0=player0+5;
                    else
                        player1=player1+5;
                }
                if(presentface==6)
                {
                    faceid = R.mipmap.ic_dice_six;
                    if(turn==0)
                        player0=player0+6;
                    else
                        player1=player1+6;
                }

                update();

                dice_face.setImageResource(faceid);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    void hold(){
        if(turn==0) {
            turn = 1;
            Player.setText("Second Players turn");
        }
        else {
            turn = 0;
            Player.setText("Second Players turn");
        }
    }


    void reset(){
        if(turn==0) {
            player0 = 0;

        }
        else {
            player1 = 0;

        }
        update();

    }

    void update(){
        p0.setText("First Players Score : "+player0);
        p1.setText("Second Players Score : "+player1);
        if(player0>=100) {
            Player.setText("First Player Won");

        }
        if(player1>=100) {
            Player.setText("Second Player Won");
        }
    }
}



