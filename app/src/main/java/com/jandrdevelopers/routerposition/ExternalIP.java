package com.jandrdevelopers.routerposition;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExternalIP {

    public static String getIp() {
        String uri = "https://ip4.seeip.org/";
        HttpURLConnection connection = null;
        String json = "";
        String resultado = "";

        try {
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            Scanner inStream = new Scanner(connection.getInputStream());
            while (inStream.hasNextLine()) {
                json += (inStream.nextLine());
            }
            resultado = (json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static String getLatLang(String ip) {
        String uri = "http://api.ipstack.com/"+ip+"?access_key=f1a01e5665903b1f4005922c6730d3ff&format=1";
        HttpURLConnection connection = null;
        String json = "";
        String resultado = "";

        try {
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            Scanner inStream = new Scanner(connection.getInputStream());
            while (inStream.hasNextLine()) {
                json += (inStream.nextLine());
            }
            resultado = (json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
