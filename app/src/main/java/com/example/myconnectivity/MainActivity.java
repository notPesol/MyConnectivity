package com.example.myconnectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button btnCheck = findViewById(R.id.button);

        Button btnWifiSetting = findViewById(R.id.button2);
        btnWifiSetting.setOnClickListener(v -> {
            openWifiSetting();
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNetwork();
            }
        });

    }

    private void openWifiSetting() {
        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(intent);
    }

    private void checkNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        String msg = "";
        if (networkInfo != null && networkInfo.isConnected()) {
            msg = "ท่านเชื่อมต่อเครือข่ายแล้ว";
        } else {
            msg = "ท่านไม่ได้เชื่อมต่อเครือข่าย";
        }
        textView.setText(msg);
    }
}