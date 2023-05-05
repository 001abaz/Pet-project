package com.example.englishzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Dictionary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Click_Books (View viev) {
        Toast.makeText(getApplicationContext(), "Era", Toast.LENGTH_LONG) .show();
    }
    public void Click_books(View v) {
        Intent intent = new Intent(MainActivity.this, BooksActivity.class);
        startActivity(intent);
    }

    public void Click_Home (View viev) {
        Toast.makeText(getApplicationContext(), "Your in home", Toast.LENGTH_LONG) .show();
    }
    public void Click_units(View v) {
        Intent intent = new Intent(MainActivity.this, UnitsActivity.class);
        startActivity(intent);
    }
    public void Click_setting(View v) {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);
    }
    public void Click_Quiz_units(View v) {
        Intent intent = new Intent(MainActivity.this, QuizUnitActivity.class);
        startActivity(intent);
    }
    public void Click_audio(View v) {
        Intent intent = new Intent(MainActivity.this, AudioActivity.class);
        startActivity(intent);
    }
    public void Click_Audio(View v) {
        Intent intent = new Intent(MainActivity.this, AudioActivity.class);
        startActivity(intent);
    }
    public void Click_Dictionary(View v) {
        Intent intent = new Intent(MainActivity.this, DictionaryActivity.class);
        startActivity(intent);
    }


}