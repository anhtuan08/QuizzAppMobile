package com.example.Quizz_app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.Quizz_app.Adapter.ListQuestionAdapter;
import com.example.Quizz_app.Data.DataQuestionTopic;
import com.example.constraint_layout.R;

import java.util.List;

public class Screen6 extends Fragment {

    List<DataQuestionTopic> dataQuestionTopics;

    TextView question;

    TextView radioButton1, radioButton2, radioButton3, radioButton4;

    TextView levelQuestion;

    TextView Answer;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question = view.findViewById(R.id.textView_Question);
        levelQuestion = view.findViewById(R.id.textView_levelAnswer);
        Answer = view.findViewById(R.id.textView_textAnswer);
        radioButton1 = view.findViewById(R.id.answer1);
        radioButton2 = view.findViewById(R.id.answer2);
        radioButton3 = view.findViewById(R.id.answer3);
        radioButton4 = view.findViewById(R.id.answer4);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen6, container, false);
    }
}