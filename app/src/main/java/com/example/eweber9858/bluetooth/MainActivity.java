package com.example.eweber9858.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.view.View;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch simpleSwitch = (Switch) findViewById(R.id.bluetoothSwitch);
        if(simpleSwitch.isChecked()) {
            //add code to poll for bluetooth signal here
        }

        Button button = findViewById(R.id.button_id);

    }

    public void light_pole_1(View view) {
        TextView tv = findViewById(R.id.tv2);
        try {
            tv.setText(get_token());
        } catch (IOException e) {
            tv.setText("fail");
        }
    }

    public String get_token() throws IOException {
        String USER_AGENT = "Mozilla/5.0";
        String POST_URL = "https://www.sic-desigocc.com:8443/api/token";
        String CONTENT_TYPE = "application/x-www-form-urlencoded";
        String HOST = "sspct2540";
        String BODY = "grant_type=password&username=DefaultAdmin&password=DefaultAdmin";

        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", CONTENT_TYPE);
        con.setRequestProperty("Host", HOST);

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        byte [] body = BODY.getBytes("UTF-8");
        os.write(body);
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader (new InputStreamReader(con.getInputStream()));
        String input;
        StringBuffer response = new StringBuffer();
        while((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();
        return input;
    }

}
