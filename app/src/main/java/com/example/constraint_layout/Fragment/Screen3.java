package com.example.constraint_layout.Fragment;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.constraint_layout.Data.ArtQuestion;
import com.example.constraint_layout.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class Screen3 extends Fragment {

    TextView question;

    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    Button btnAnswer;

    Button  btngetId;

    ArtQuestion artQuestion;

    AssetManager assetManager;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question = view.findViewById(R.id.textView_Question);
        radioButton1 = view.findViewById(R.id.button1);
        radioButton2 = view.findViewById(R.id.button2);
        radioButton3 = view.findViewById(R.id.button3);
        radioButton4 = view.findViewById(R.id.button4);
        btnAnswer = view.findViewById(R.id.btnAnswer);

        loadAllQuestion();

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheck(radioButton1, radioButton2, radioButton3, radioButton4);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheck(radioButton2, radioButton1, radioButton3, radioButton4);
            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheck(radioButton3, radioButton1, radioButton2, radioButton4);
            }
        });

        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCheck(radioButton4, radioButton1, radioButton2, radioButton3);
            }
        });
        checkClick(radioButton1, radioButton2, radioButton3, radioButton4);


        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkClick(radioButton1, radioButton2, radioButton3, radioButton4)) {
                        radioButton1.setError("");
                        radioButton1.requestFocus();
                }
                else {
                   // Navigation.findNavController(v).navigate(R.id.action_screen3_to_screen2);
                }

            }
        });

    }

    private void loadAllQuestion() {
        String jsonQuiz = loadJsonFromAsset("easyQuestion.json");
        try {
                JSONObject jsonObject = new JSONObject(jsonQuiz);
                JSONArray uerArray = jsonObject.getJSONArray("easyQuestionArt");
                for (int i = 0; i < uerArray.length(); i++){
                    JSONObject question = uerArray.getJSONObject(i);

                }



        }
        catch (JSONException e){
            Log.d("Question", "Failed");
        }

    }

    private String loadJsonFromAsset(String s) {
        String json = null;
        try {

            InputStream inputStream = getActivity().getApplicationContext().getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {

        }
        return json;
    }

    private void setCheck(RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4) {
            if(radioButton1.isChecked()){
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
            }
    }


    private boolean checkClick(RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4) {
            if(!radioButton1.isChecked() && !radioButton2.isChecked() && !radioButton3.isChecked() && !radioButton4.isChecked()){
                return false;
            }
            return true;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen3, container, false);
    }





}