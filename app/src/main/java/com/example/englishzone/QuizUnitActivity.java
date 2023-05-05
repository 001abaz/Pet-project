package com.example.englishzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuizUnitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_unit);
    }
    public void Click_Home(View v) {
        Intent intent = new Intent(QuizUnitActivity.this, MainActivity.class);
        startActivity(intent);
    }
}