package com.example.englishzone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DictionaryActivity extends AppCompatActivity {
    private String[] englishWords = {"apple", "banana", "orange", "pear", "cat", "dog", "book", "table", "sun", "moon", "pen", "car", "chair", "house", "tree"};
    private String[] russianWords = {"яблоко", "банан", "апельсин", "груша", "кот", "собака", "книга", "стол", "солнце", "луна", "ручка", "машина", "стул", "дом", "дерево"};
    private String[] transcriptions = {"[ˈæpəl]", "[bəˈnɑːnə]", "[ˈɒrɪndʒ]", "[pɛər]", "[kæt]", "[dɒg]", "[bʊk]", "[ˈteɪbl̩]", "[sʌn]", "[muːn]", "[pɛn]", "[kɑːr]", "[tʃeər]", "[haʊs]", "[tri]"};
    private int currentWordIndex = 0;

    private TextView dictionaryWordTextView;
    private TextView dictionaryTranscriptionTextView;
    private TextView dictionaryTranslationTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dictionaryWordTextView = findViewById(R.id.dictionary_eng);
        dictionaryTranscriptionTextView = findViewById(R.id.dictionary_tra);
        dictionaryTranslationTextView = findViewById(R.id.dictionary_ru);
        setDictionaryWord(currentWordIndex);

        Button nextButton = findViewById(R.id.next_dictionary);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWordIndex = (currentWordIndex + 1) % englishWords.length;
                setDictionaryWord(currentWordIndex);
            }
        });

        Button backButton = findViewById(R.id.back_dictionary);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWordIndex = (currentWordIndex + englishWords.length - 1) % englishWords.length;
                setDictionaryWord(currentWordIndex);
            }
        });
    }

    private void setDictionaryWord(int index) {
        String englishWord = englishWords[index];
        String russianWord = russianWords[index];
        String transcription = transcriptions[index];
        dictionaryWordTextView.setText(englishWord);
        dictionaryTranscriptionTextView.setText(transcription);
        dictionaryTranslationTextView.setText(russianWord);
    }

    public void Click_Home(View v) {
        Intent intent = new Intent(DictionaryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}