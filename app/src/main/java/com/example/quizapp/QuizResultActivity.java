package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizResultActivity extends AppCompatActivity {
    private TextView tvScore, tvScoreMessage;
    private Button btnRetry, btnHome;
    private int score = 0;
    private int total = 0;
    private String quizTitle = "";
    private String quizId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        tvScore = findViewById(R.id.tvScore);
        tvScoreMessage = findViewById(R.id.tvScoreMessage);
        btnRetry = findViewById(R.id.btnRetryQuiz);
        btnHome = findViewById(R.id.btnHome);

        // Get all intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("score", 0);
            total = extras.getInt("total", 0);
            quizTitle = extras.getString("quiz_title", "Quiz");
            quizId = extras.getString("quiz_id", "");
        }

        // Display score
        String scoreText = score + "/" + total;
        tvScore.setText(scoreText);

        // Show motivational message based on score
        double percentage = (total > 0) ? (score * 100.0) / total : 0;
        String message;
        if (percentage >= 80) {
            message = "Excellent! You're a genius!";
        } else if (percentage >= 60) {
            message = "Good job! Keep learning!";
        } else if (percentage >= 40) {
            message = "Nice try! Review your answers!";
        } else {
            message = "Don't give up! Practice makes perfect!";
        }
        tvScoreMessage.setText(message);

        // Retry button - restart the same quiz
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizId != null && !quizId.isEmpty()) {
                    Intent intent = new Intent(QuizResultActivity.this, QuizQuestionActivity.class);
                    intent.putExtra("quiz_id", quizId);
                    startActivity(intent);
                    finish();
                } else {
                    // If no quiz ID, go back to selection
                    Intent intent = new Intent(QuizResultActivity.this, QuizSelectionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        // Home button
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}