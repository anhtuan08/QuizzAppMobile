package com.example.Quizz_app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.Quizz_app.Activity.MainActivity;
import com.example.constraint_layout.R;


public class Screen4 extends Fragment {
    TextView correctQuestion;
    Button btnComplete, btnShareAchives, btnplayAgain;

    int Scores;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        correctQuestion   = view.findViewById(R.id.textView_numberTruequestion);
        btnComplete       = view.findViewById(R.id.btnComplete);
        btnShareAchives   = view.findViewById(R.id.btnshareAchives);
        btnplayAgain         = view.findViewById(R.id.btnPlayAgain);

        correctQuestion.setText(String.valueOf(MainActivity.getCorrectQuestion()));

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_screen4_to_screen1);
            }
        });

        btnShareAchives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareActivity = new Intent();
                shareActivity.setAction(Intent.ACTION_SEND);
                shareActivity.putExtra("this is: ", Scores);
                shareActivity.setType("text/plain");

                Intent send = Intent.createChooser(shareActivity, null);
                startActivity(send);
            }
        });
        btnplayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_screen4_to_screen3);
            }
        });
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen4, container, false);
    }
}