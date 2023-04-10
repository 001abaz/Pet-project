package com.example.englishzone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private String questionText;
    private String correctAnswer;
    private List<String> answerChoices;

    public Question(String questionText, String correctAnswer, String... answerChoices) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.answerChoices = new ArrayList<>(Arrays.asList(answerChoices));
        this.answerChoices.add(correctAnswer);
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getAnswerChoices() {
        return answerChoices;
    }
}
