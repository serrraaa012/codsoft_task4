package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnStartNewQuiz, btnViewQuizzes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartNewQuiz = findViewById(R.id.btnStartNewQuiz);
        btnViewQuizzes = findViewById(R.id.btnViewQuizzes);

        btnStartNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizSelectionActivity.class);
                intent.putExtra("start_random", true);
                startActivity(intent);
            }
        });

        btnViewQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}