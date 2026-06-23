package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

public class QuizQuestionActivity extends AppCompatActivity {
    private TextView tvQuizTitle, tvQuestionNumber, tvQuestionText, tvFeedback;
    private RadioGroup radioGroup;
    private RadioButton[] radioButtons = new RadioButton[4];
    private Button btnSubmit;

    private QuizModel quiz;
    private List<QuestionModel> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private List<Boolean> answerResults = new ArrayList<>();
    private boolean isAnswered = false;
    private String quizId; // Store quiz ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        initializeViews();
        loadQuiz();
        displayQuestion();
    }

    private void initializeViews() {
        tvQuizTitle = findViewById(R.id.tvQuizTitle);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvQuestionText = findViewById(R.id.tvQuestionText);
        tvFeedback = findViewById(R.id.tvFeedback);
        radioGroup = findViewById(R.id.radioGroupOptions);
        btnSubmit = findViewById(R.id.btnSubmitAnswer);

        radioButtons[0] = findViewById(R.id.radioOption0);
        radioButtons[1] = findViewById(R.id.radioOption1);
        radioButtons[2] = findViewById(R.id.radioOption2);
        radioButtons[3] = findViewById(R.id.radioOption3);

        // Set the submit button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnswered) {
                    submitAnswer();
                } else {
                    goToNextQuestion();
                }
            }
        });
    }

    private void loadQuiz() {
        quizId = getIntent().getStringExtra("quiz_id");
        quiz = QuizDatabase.getInstance().getQuizById(quizId);
        if (quiz != null) {
            questions = quiz.getQuestions();
            tvQuizTitle.setText(quiz.getQuizTitle());
        } else {
            Toast.makeText(this, "Quiz not found!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            isAnswered = false;
            QuestionModel question = questions.get(currentQuestionIndex);
            tvQuestionNumber.setText("Question " + (currentQuestionIndex + 1) + "/" + questions.size());
            tvQuestionText.setText(question.getQuestionText());

            List<String> options = question.getOptions();
            for (int i = 0; i < radioButtons.length; i++) {
                if (i < options.size()) {
                    radioButtons[i].setText(options.get(i));
                    radioButtons[i].setVisibility(View.VISIBLE);
                    radioButtons[i].setChecked(false);
                    radioButtons[i].setEnabled(true);
                } else {
                    radioButtons[i].setVisibility(View.GONE);
                }
            }

            radioGroup.clearCheck();
            tvFeedback.setText("");
            tvFeedback.setVisibility(View.GONE);
            btnSubmit.setText("SUBMIT ANSWER");
            btnSubmit.setEnabled(true);

        } else {
            showResults();
        }
    }

    private void submitAnswer() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            return;
        }

        QuestionModel question = questions.get(currentQuestionIndex);
        int selectedIndex = -1;
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].getId() == selectedId) {
                selectedIndex = i;
                break;
            }
        }

        boolean isCorrect = (selectedIndex == question.getCorrectAnswerIndex());
        if (isCorrect) {
            score++;
        }
        answerResults.add(isCorrect);

        // Disable radio buttons after submission
        for (RadioButton rb : radioButtons) {
            rb.setEnabled(false);
        }

        // Show feedback
        String feedback = isCorrect ? "Correct!" : "Incorrect! The correct answer is: " +
                question.getOptions().get(question.getCorrectAnswerIndex());
        tvFeedback.setText(feedback);
        tvFeedback.setVisibility(View.VISIBLE);
        tvFeedback.setTextColor(isCorrect ? ContextCompat.getColor(this, android.R.color.holo_green_dark) :
                ContextCompat.getColor(this, android.R.color.holo_red_dark));

        // Mark as answered and change button text
        isAnswered = true;
        btnSubmit.setText("NEXT QUESTION →");
        btnSubmit.setEnabled(true);
    }

    private void goToNextQuestion() {
        currentQuestionIndex++;
        displayQuestion();
    }

    private void showResults() {
        Intent intent = new Intent(this, QuizResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("total", questions.size());
        intent.putExtra("quiz_title", quiz.getQuizTitle());
        intent.putExtra("quiz_id", quizId); // Pass the quiz ID
        intent.putExtra("total_questions", questions.size()); // Add this extra
        startActivity(intent);
        finish();
    }
}