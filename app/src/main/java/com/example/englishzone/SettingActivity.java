package com.example.englishzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    public void Click_Upgrade (View viev) {
        Toast.makeText(getApplicationContext(), "Last upgrade", Toast.LENGTH_LONG) .show();
    }
    public void Click_Home(View v) {
        finish();
    }


}
