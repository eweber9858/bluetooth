package com.example.eweber9858.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch simpleSwitch = (Switch) findViewById(R.id.bluetoothSwitch);
        if(simpleSwitch.isChecked()) {
            //add code to poll for bluetooth signal here
        }
    }

}
