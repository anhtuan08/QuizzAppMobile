package com.example.Quizz_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.Quizz_app.ViewModel.ItemViewModel;
import com.example.constraint_layout.R;


public class MainActivity extends AppCompatActivity {

    ItemViewModel itemViewModel;

    private static Integer level;

    private static String topic;

    private static String answer;

    private static Integer id;

    private static Integer scores;

    private static Integer correctQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        itemViewModel.getLevel().observe(this, level -> {
            setLevel(level);
        });


        itemViewModel.getTopic().observe(this, topic -> {
            // Perform an action with the latest item data.
            setTopic(topic);
        });

        itemViewModel.getAnswer().observe(this, answer -> {
            setAnswer(answer);
        });

        itemViewModel.getId().observe(this, id -> {
            setId(Integer.valueOf(id));
        });

        itemViewModel.getScores().observe(this, scores -> {
            setScores(scores);
        });

        itemViewModel.getCorrectQuestion().observe(this, correctQuestion -> {
            setCorrectQuestion(correctQuestion);
        });
    }

    public static String getTopic () {
        return topic;
    }

    public void setTopic (String topic){
        this.topic = topic;
    }


    public static Integer getLevel () {
        return level;
    }

    public void setLevel (Integer level){
        this.level = level;
    }

    public static String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public static Integer getCorrectQuestion() {
        return correctQuestion;
    }

    public void setCorrectQuestion(Integer correctQuestion) {
        this.correctQuestion = correctQuestion;
    }
}