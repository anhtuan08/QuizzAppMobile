package com.example.constraint_layout.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.constraint_layout.R;


public class Screen4 extends Fragment {
    TextView TotalScore;
    Button btnComplete;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TotalScore = view.findViewById(R.id.textView_numberTruequestion);
        btnComplete  =view.findViewById(R.id.btnComplete);

       getParentFragmentManager().setFragmentResultListener("request", this, new FragmentResultListener() {
           @Override
           public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
               String abc = result.getString("count");
                TotalScore.setText(abc);
           }
       });

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_screen4_to_screen1);
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