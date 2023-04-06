package com.example.englishzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UnitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units);


    }
    public void Click_Home(View v) {
        Intent intent = new Intent(UnitsActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void Click_Unit1(View v) {
        Intent intent = new Intent(UnitsActivity.this, AudioActivity.class);
        startActivity(intent);
    }
}