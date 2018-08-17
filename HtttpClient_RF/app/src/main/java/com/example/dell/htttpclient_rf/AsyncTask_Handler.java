package com.example.dell.htttpclient_rf;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.SocketException;

/**
 * Created by dell on 7/4/2016.
 */
public class AsyncTask_Handler extends AsyncTask<String,String,String> {




    @Override
    protected String doInBackground(String... params) {
        String _RESPONSE="";
        try{
            Client_Browser_Receiver _EXAMPLE=new Client_Browser_Receiver();
            _EXAMPLE.run(params[0]);
            _RESPONSE=_EXAMPLE.GetOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return _RESPONSE;
    }



}



