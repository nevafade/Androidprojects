package com.example.dell.htttpclient_rf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by dell on 7/4/2016.
 */
public class Client_Browser_Receiver extends Thread{
    String _OUTPUT="";

    public Client_Browser_Receiver()throws IOException
    {

    }

    public void run(String URi) {


        try {

            String httpsURL = "https://"+URi;
            URL myurl = new URL(httpsURL);
            HttpsURLConnection con = (HttpsURLConnection) myurl.openConnection();
            InputStream ins = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins);
            BufferedReader in = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                _OUTPUT=_OUTPUT+inputLine;
                }



            in.close();
        } catch (MalformedURLException e) {
            _OUTPUT=_OUTPUT+e.toString();
        } catch (IOException e) {
            _OUTPUT=_OUTPUT+e.toString();
        }

    }


    public String GetOutput(){
        return _OUTPUT;


    }

}

