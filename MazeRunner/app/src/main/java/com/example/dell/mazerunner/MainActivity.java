package com.example.dell.mazerunner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{WifiManager wifiManager;
    String wifis[];
    int signalStrengths[];
    WifiScanReceiver wifiScanReceiver;
    boolean levels[];
    RelativeLayout start;
    TextView heading,sub;
    levelcounter link=new levelcounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(RelativeLayout) findViewById(R.id.mainlayout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        levels = new boolean[5];
        wifiManager=(WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiScanReceiver=new WifiScanReceiver();
        wifiManager.startScan();
        heading=(TextView) findViewById(R.id.heading);
        sub=(TextView) findViewById(R.id.subheading);

        Toast.makeText(MainActivity.this,""+levelcounter.text,Toast.LENGTH_LONG).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(levelcounter.level==0)
                levelcounter.level=1;
                link.execute();
                wifiManager.startScan();
                Intent i=new Intent(MainActivity.this,Clue.class);

                startActivity(i);
                Snackbar.make(view, "scanning...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onPause() {
        unregisterReceiver(wifiScanReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerReceiver(wifiScanReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        Toast.makeText(MainActivity.this,"Scanning.... ",Toast.LENGTH_LONG).show();
        wifiManager.startScan();

        super.onResume();
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

    @Override
    public void onClick(View v) {

        Intent i=new Intent(MainActivity.this,Clue.class);
        startActivity(i);



    }

    private class WifiScanReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            List<ScanResult> wifiScanList = wifiManager.getScanResults();     //listArray of all the wifi hotspots
            ScanResult result[] = wifiScanList.toArray(new ScanResult[wifiScanList.size()]);  //getting an array from list
            wifis = new String[wifiScanList.size()];               //stores the ssid
            signalStrengths = new int[wifiScanList.size()];        //stores level

            for (int i = 0; i < wifiScanList.size(); i++) {
                //wifis[i] = ((wifiScanList.get(i)).toString());
                wifis[i] = ((result[i].SSID));                 //extracting ssid from result of wifi scan
                signalStrengths[i]=result[i].level;           //extracting level from result of wifi scan
            }
            for(int i=0;i<wifis.length;i++)
            {


                 if(wifis[i].contentEquals("Rangoli") && signalStrengths[i] >= -40 && levelcounter.level==1){
                     if(levelone.precedence[1]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelone.precedence[1]=true;

                     }
                     Toast.makeText(MainActivity.this,"Number of clues unlocked: "+levelcounter.count,Toast.LENGTH_LONG).show();
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=2;
                         Toast.makeText(MainActivity.this,"youv reached the next level: "+levelcounter.level,Toast.LENGTH_LONG).show();
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("DirectorsOffice") && signalStrengths[i] >= -40 && levelcounter.level==1){
                     if(levelone.precedence[2]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelone.precedence[2]=true;

                     }
                     Toast.makeText(MainActivity.this,"Number of clues unlocked: "+levelcounter.count,Toast.LENGTH_LONG).show();
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=2;
                         Toast.makeText(MainActivity.this,"youv reached the next level: "+levelcounter.level,Toast.LENGTH_LONG).show();
                         link.execute();
                     }

                }

                else if(wifis[i].contentEquals("DDirectorsOffice") && signalStrengths[i] >= -40 && levelcounter.level==1){
                     if(levelone.precedence[3]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelone.precedence[3]=true;

                     }
                     Toast.makeText(MainActivity.this,"Number of clues unlocked: "+levelcounter.count,Toast.LENGTH_LONG).show();
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=2;
                         Toast.makeText(MainActivity.this,"youv reached the next level: "+levelcounter.level,Toast.LENGTH_LONG).show();
                         link.execute();
                     }

                }

                else if(wifis[i].contentEquals("Schc") && signalStrengths[i] >= -40 && levelcounter.level==1){
                     if(levelone.precedence[4]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelone.precedence[4]=true;

                     }
                     Toast.makeText(MainActivity.this,"Number of clues unlocked: "+levelcounter.count,Toast.LENGTH_LONG).show();
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=2;
                         link.execute();
                         Toast.makeText(MainActivity.this,"youv reached the next level: "+levelcounter.level,Toast.LENGTH_LONG).show();

                     }

                }

                else if(wifis[i].contentEquals("NaacShed") && signalStrengths[i] >= -40 && levelcounter.level==2){
                     if(leveltwo.precedence[1]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         leveltwo.precedence[1]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=3;
                         link.execute();
                     }

                }

                else if(wifis[i].contentEquals("ChemistryLab") && signalStrengths[i] >= -40 && levelcounter.level==2){
                     if(leveltwo.precedence[2]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         leveltwo.precedence[2]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=3;
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("GasContainerShed") && signalStrengths[i] >= -40 && levelcounter.level==2){
                     if(leveltwo.precedence[3]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         leveltwo.precedence[3]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=3;
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("CCD") && signalStrengths[i] >= -40 && levelcounter.level==3){
                     if(levelthree.precedence[1]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelthree.precedence[1]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=4;
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("CulinaryArts") && signalStrengths[i] >= -40 && levelcounter.level==3){
                     if(levelthree.precedence[2]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelthree.precedence[2]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=4;
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("BBlock") && signalStrengths[i] >= -40 && levelcounter.level==3){
                     if(levelthree.precedence[3]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelthree.precedence[3]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=4;
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("CoffeeStop") && signalStrengths[i] >= -40 && levelcounter.level==3){
                     if(levelthree.precedence[4]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelthree.precedence[4]=true;

                     }
                     if(levelcounter.count==levelcounter.max){
                         levelcounter.count=0;
                         levelcounter.level=4;
                         link.execute();
                     }
                }

                else if(wifis[i].contentEquals("MorgueChemLab") && signalStrengths[i] >= -40 && levelcounter.level==4){
                     if(levelfour.precedence[1]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelthree.precedence[1]=true;

                     }
                     if(levelcounter.count==levelcounter.max){

                         levelcounter.level=4;
                         link.execute();
                     }
                }

                 else if(wifis[i].contentEquals("Library") && signalStrengths[i] >= -40 && levelcounter.level==4){
                     if(levelfour.precedence[2]==false) {
                         levelcounter.count = levelcounter.count + 1;
                         levelthree.precedence[2]=true;

                     }
                     if(levelcounter.count==levelcounter.max){

                         levelcounter.level=4;
                         link.execute();
                     }
                 }
            }
        }
    }

}
