package com.example.dell.ipgetter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.Uri;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    /*
    WifiInfo ob;
    int _IP,_GATEWAY_IP,_NETWORK;
    String _IPv4="";
    String _ARGUMENT="";
    String _Mac_IP;
    String _NETWORK_ID="";
    String _SSID_IP;
    String _BSSID_IP="";
    String _IPaddress="";
    Button butt,_PURP;
    TextView txt;
    WifiManager wifiManager;
    int _PORT,_LENGHT;
    DhcpInfo _Dhcp;
    String[] _LIST;
    EditText _HOST;
    */
    WebView _WEBPAGE;
    EditText _URL;
    Button _GO;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        final Activity activity=this;
        _GO=(Button) findViewById(R.id.Go);
        _URL=(EditText) findViewById(R.id.editText);
        _WEBPAGE=(WebView) findViewById(R.id.WebVeiw);
        _WEBPAGE.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(activity, "Oh no! " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        _WEBPAGE.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000);
            }
        });
        _WEBPAGE.getSettings().setJavaScriptEnabled(true);
        _WEBPAGE.setVerticalScrollBarEnabled(false);
        _WEBPAGE.setHorizontalScrollBarEnabled(false);




        _GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                _WEBPAGE.loadUrl(_URL.getText().toString());
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


    String _CODE(int _IPARGUMENT){

        if(_IPARGUMENT==0) {
            _IPARGUMENT=16820416;
        }


            String _GATEWAY = Integer.toHexString(_IPARGUMENT);
            int _LENGHT = _GATEWAY.length();

            if (_LENGHT == 7) {
                _GATEWAY = "0" + _GATEWAY;
            }

            int d = Integer.valueOf(_GATEWAY.substring(0, 2), 16);
            int c = Integer.valueOf(_GATEWAY.substring(2, 4), 16);
            int b = Integer.valueOf(_GATEWAY.substring(4, 6), 16);
            int a = Integer.valueOf(_GATEWAY.substring(6), 16);
            String _RETURN = a + "." + b + "." + c + "." + d;
            return _RETURN;


    }
    /*


    String[] getWifiNetworks() {
        List<WifiConfiguration> networks = wifiManager.getConfiguredNetworks();
        if (networks == null) {
            return new String[0];
        }
        String[] ssids = new String[networks.size()];
        for (int ii=0 ; ii<networks.size(); ii++) {
            ssids[ii] = networks.get(ii).SSID;
        }
        return ssids;
    }
    */





}
