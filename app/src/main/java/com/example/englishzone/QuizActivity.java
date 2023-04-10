package com.example.englishzone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;

    private TextView textViewQuestion;
    private RadioGroup radioGroupAnswers;
    private Button buttonNext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Get references to UI elements
        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupAnswers = findViewById(R.id.radioGroupAnswers);
        buttonNext = findViewById(R.id.buttonNext);

        // Create the quiz questions
        questions.add(new Question("What is the capital of France?", "Paris", "Berlin", "London", "Madrid"));
        questions.add(new Question("What is the largest country in the world by land area?", "Russia", "China", "United States", "Canada"));
        questions.add(new Question("What is the highest mountain in the world?", "Mount Everest", "K2", "Kangchenjunga", "Lhotse"));
        questions.add(new Question("What is the smallest country in the world by land area?", "Vatican City", "Monaco", "Nauru", "Tuvalu"));

        // Display the first question
        displayQuestion(currentQuestionIndex);

        // Set up the "Next" button click listener
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion(int questionIndex) {
        // Get the current question
        Question currentQuestion = questions.get(questionIndex);

        // Set the question text
        textViewQuestion.setText(currentQuestion.getQuestionText());

        // Clear the answer choices
        radioGroupAnswers.clearCheck();
        radioGroupAnswers.removeAllViews();

        // Add the answer choices
        List<String> answerChoices = currentQuestion.getAnswerChoices();
        for (int i = 0; i < answerChoices.size(); i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answerChoices.get(i));
            radioGroupAnswers.addView(radioButton);
        }
    }

    private void checkAnswer() {
        // Get
        // Get the current question
        Question currentQuestion = questions.get(currentQuestionIndex);

        // Get the selected answer
        int selectedAnswerId = radioGroupAnswers.getCheckedRadioButtonId();

        // Check if an answer was selected
        if (selectedAnswerId == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the selected answer is correct
        RadioButton selectedAnswerRadioButton = findViewById(selectedAnswerId);
        String selectedAnswerText = selectedAnswerRadioButton.getText().toString();
        if (selectedAnswerText.equals(currentQuestion.getCorrectAnswer())) {
            score++;
        }

        // Increment the question index
        currentQuestionIndex++;

        // Check if there are more questions
        if (currentQuestionIndex < questions.size()) {
            // Display the next question
            displayQuestion(currentQuestionIndex);
        } else {
            // Display the final score
            String message = "Your score is " + score + " out of " + questions.size();
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}