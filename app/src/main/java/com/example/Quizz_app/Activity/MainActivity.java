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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        itemViewModel.getLevel().observe(this, item -> {
            // Perform an action with the latest item data.
            setLevel(item);
        });


        itemViewModel.getTopic().observe(this, item -> {
            // Perform an action with the latest item data.
            setTopic(item);
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
}