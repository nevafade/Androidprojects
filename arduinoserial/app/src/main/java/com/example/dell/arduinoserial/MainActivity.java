package com.example.dell.arduinoserial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.bluetooth.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
}

    void setup() {
        pinMo de(LED,OUTPUT);   // declare the LED's pin as output
        pinMode(RESET,OUTPUT);   // declare the LED's pin as output
        Serial.begin(115200);        // connect to the serial port
        digitalWrite(RESET, HIGH);
        delay(10);
        digitalWrite(RESET, LOW);
        delay(2000);
        Serial.println("SET BT PAGEMODE 3 2000 1");
        Serial.println("SET BT NAME ARDUINOBT");
        Serial.println("SET BT ROLE 0 f 7d00");
        Serial.println("SET CONTROL ECHO 0");
        Serial.println("SET BT AUTH * 12345");
        Serial.println("SET CONTROL ESCAPE - 00 1");
        Serial.println("SET CONTROL BAUD 115200,8n1");      //first release 19200
    }

    void loop () {
        digitalWrite(LED, HIGH);
        delay(100);
        digitalWrite(LED, LOW);
        Serial.println("ciao");
        delay(1000);
    }

