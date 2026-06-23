package com.example.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    private List<QuizModel> quizList;
    private OnQuizClickListener listener;

    public interface OnQuizClickListener {
        void onQuizClick(QuizModel quiz);
    }

    public QuizAdapter(List<QuizModel> quizList, OnQuizClickListener listener) {
        this.quizList = quizList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quiz, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        QuizModel quiz = quizList.get(position);
        holder.tvQuizTitle.setText(quiz.getQuizTitle());
        holder.tvQuestionCount.setText(quiz.getQuestions().size() + " questions");

        holder.itemView.setOnClickListener(v -> listener.onQuizClick(quiz));
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    static class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuizTitle, tvQuestionCount;

        QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuizTitle = itemView.findViewById(R.id.tvQuizTitle);
            tvQuestionCount = itemView.findViewById(R.id.tvQuestionCount);
        }
    }
}