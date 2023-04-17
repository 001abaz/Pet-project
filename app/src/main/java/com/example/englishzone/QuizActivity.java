package com.example.englishzone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView mTextViewQuestion;
    private RadioGroup mRadioGroupAnswers;
    private int mCurrentQuestionIndex = 0;
    private boolean[] mAnswers;
    private String[] mQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize views
        mTextViewQuestion = findViewById(R.id.textViewQuestion);
        mRadioGroupAnswers = findViewById(R.id.radioGroupAnswers);
        Button mButtonNext = findViewById(R.id.buttonNext);

        // Initialize questions and answers
        mQuestions = getResources().getStringArray(R.array.questions);
        mQuestions = getResources().getStringArray(R.array.questions);
        mQuestions = getResources().getStringArray(R.array.questions);
        mAnswers = new boolean[mQuestions.length];


        // Set first question
        setQuestion();

        // Set onclick listener for next button
        mButtonNext.setOnClickListener(v -> {
            // Get selected answer
            int selectedAnswerId = mRadioGroupAnswers.getCheckedRadioButtonId();
            boolean answer;

            // Check if answer is correct
            if (selectedAnswerId == R.id.radioButtonTrue) {
                answer = true;
            } else if (selectedAnswerId == R.id.radioButtonFalse) {
                answer = false;
            } else {
                Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                return;
            }

            mAnswers[mCurrentQuestionIndex] = answer;
            mRadioGroupAnswers.clearCheck();

            // Move to next question or show results
            if (mCurrentQuestionIndex < mQuestions.length - 1) {
                mCurrentQuestionIndex++;
                setQuestion();
            } else {
                showResults();
            }
        });
    }

    private void setQuestion() {
        mTextViewQuestion.setText(mQuestions[mCurrentQuestionIndex]);
    }

    private void showResults() {
        int correctAnswers = 0;

        for (boolean answer : mAnswers) {
            if (answer) {
                correctAnswers++;
            }
        }

        // Create alert dialog builder
        AlertDialog.Builder mResultsDialogBuilder = new AlertDialog.Builder(this);
        mResultsDialogBuilder.setTitle("Quiz Results");
        mResultsDialogBuilder.setMessage("You got " + correctAnswers + " out of " + mQuestions.length + " correct.");

        // Add buttons to dialog
        mResultsDialogBuilder.setPositiveButton("Go Home", (dialog, which) -> {
            // Close the activity and return to main activity
            finish();
        });

        mResultsDialogBuilder.setNegativeButton("Repeat Quiz", (dialog, which) -> {
            // Reset quiz and start again
            mCurrentQuestionIndex = 0;
            mAnswers = new boolean[mQuestions.length];
            setQuestion();
        });

        // Create and show dialog
        AlertDialog resultsDialog = mResultsDialogBuilder.create();
        resultsDialog.show();
    }
}
