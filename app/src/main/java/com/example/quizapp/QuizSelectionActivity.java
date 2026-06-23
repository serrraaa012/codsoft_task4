package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Random;

public class QuizSelectionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuizAdapter adapter;
    private Button btnRandomQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection);

        recyclerView = findViewById(R.id.recyclerViewQuizzes);
        btnRandomQuiz = findViewById(R.id.btnRandomQuiz);

        List<QuizModel> quizzes = QuizDatabase.getInstance().getAllQuizzes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuizAdapter(quizzes, quiz -> {
            startQuiz(quiz.getQuizId());
        });
        recyclerView.setAdapter(adapter);

        btnRandomQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRandomQuiz();
            }
        });

        // Check if we need to start a random quiz
        if (getIntent().getBooleanExtra("start_random", false)) {
            startRandomQuiz();
        }
    }

    private void startRandomQuiz() {
        List<QuizModel> quizzes = QuizDatabase.getInstance().getAllQuizzes();
        if (!quizzes.isEmpty()) {
            Random random = new Random();
            QuizModel randomQuiz = quizzes.get(random.nextInt(quizzes.size()));
            startQuiz(randomQuiz.getQuizId());
        }
    }

    private void startQuiz(String quizId) {
        Intent intent = new Intent(this, QuizQuestionActivity.class);
        intent.putExtra("quiz_id", quizId);
        startActivity(intent);
        finish();
    }
}