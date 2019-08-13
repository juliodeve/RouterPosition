package com.jandrdevelopers.routerposition;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String ip = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getIp();

    }

    private void getLatLang(final String ip) {
        final Thread tr = new Thread() {
            @Override
            public void run() {
                super.run();
                final String resultado = ExternalIP.getLatLang(ip);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
        tr.start();
    }

    private void getIp() {
        final Thread tr = new Thread() {
            @Override
            public void run() {
                super.run();
                final String resultado = ExternalIP.getIp();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ip = resultado;
                        getLatLang(resultado);
                    }
                });
            }
        };
        tr.start();
    }


}
