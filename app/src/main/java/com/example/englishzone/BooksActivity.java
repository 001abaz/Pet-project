package com.example.englishzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
    }
    public void Click_Books (View viev) {
        Toast.makeText(getApplicationContext(), "Window Books", Toast.LENGTH_LONG) .show();
    }
    public void Click_Home(View v) {
        Intent intent = new Intent(BooksActivity.this, MainActivity.class);
        startActivity(intent);
    }
}