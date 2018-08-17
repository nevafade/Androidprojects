package com.example.dell.techsetgov3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.util.List;

/**
 * Created by dell on 10/6/2017.
 */
public class WifiScanReceiver extends BroadcastReceiver {

    WifiManager wifiManager;

    @Override
    public void onReceive(Context context, Intent intent) {


        wifiManager=(WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        wifiManager.startScan();
        List<ScanResult> wifiScanList = wifiManager.getScanResults();     //listArray of all the wifi hotspots
        ScanResult result[] = wifiScanList.toArray(new ScanResult[wifiScanList.size()]);  //getting an array from list
        String wifis[] = new String[wifiScanList.size()];               //stores the ssid
        int signalStrengths[] = new int[wifiScanList.size()];

        for (int i = 0; i < wifiScanList.size(); i++) {
            //wifis[i] = ((wifiScanList.get(i)).toString());
            wifis[i] = ((result[i].SSID));                 //extracting ssid from result of wifi scan
            signalStrengths[i]=result[i].level;           //extracting level from result of wifi scan
        }

        for(int i=0;i<wifis.length;i++){

            if(wifis[i].contentEquals("Rangoli") && signalStrengths[i] >= -40 ){
                LevelTrack.cluesSolved++;

            }
        }


    }
}
