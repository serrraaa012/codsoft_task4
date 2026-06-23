package com.example.quizapp;

import java.util.List;

public class QuizModel {
    private String quizId;
    private String quizTitle;
    private List<QuestionModel> questions;

    public QuizModel(String quizId, String quizTitle, List<QuestionModel> questions) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.questions = questions;
    }

    public String getQuizId() { return quizId; }
    public String getQuizTitle() { return quizTitle; }
    public List<QuestionModel> getQuestions() { return questions; }
}