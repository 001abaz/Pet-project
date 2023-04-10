package com.example.englishzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DictionaryActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    Button pronunciationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        mPlayer= MediaPlayer.create(this, R.raw.music);
        pronunciationButton = findViewById(R.id.playButton);

    }

    public void play(View view){

        mPlayer.start();
        pronunciationButton.setEnabled(false);

    }

    public void Click_Home(View v) {
        Intent intent = new Intent(DictionaryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}