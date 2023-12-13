package com.example.Quizz_app.Fragment;

import android.annotation.SuppressLint;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.Quizz_app.Activity.MainActivity;
import com.example.Quizz_app.Data.DataProduct;
import com.example.Quizz_app.Data.DataQuestionTopic;
import com.example.Quizz_app.ViewModel.ItemViewModel;
import com.example.constraint_layout.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Screen3 extends Fragment {

    TextView question;

    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    Button btnAnswer;

    List<DataQuestionTopic> listTopic;

    int getCurrentquestion = 0;

    int count = 0;

    int totalScores = 0;

    String SelectedTopic;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question = view.findViewById(R.id.textView_Question);
        radioButton1 = view.findViewById(R.id.button1);
        radioButton2 = view.findViewById(R.id.button2);
        radioButton3 = view.findViewById(R.id.button3);
        radioButton4 = view.findViewById(R.id.button4);
        btnAnswer = view.findViewById(R.id.btnAnswer);
        SelectedTopic = MainActivity.getTopic();
        getLevelTopic();
        setQuestionScreen(getCurrentquestion);


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
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (!checkClick(radioButton1, radioButton2, radioButton3, radioButton4)) {
                        radioButton1.setError("");
                        radioButton1.requestFocus();
                        return;
                }
                else {
                        if(radioButton1.isChecked()){
                           count = listTopic.get(getCurrentquestion).getQ1().equals(listTopic.get(getCurrentquestion).getAnswer())?  count + 1 : count;

                        } else if (radioButton2.isChecked()) {
                            count = listTopic.get(getCurrentquestion).getQ2().equals(listTopic.get(getCurrentquestion).getAnswer())? count + 1: count;

                        } else if (radioButton3.isChecked()) {
                            count = listTopic.get(getCurrentquestion).getQ3().equals(listTopic.get(getCurrentquestion).getAnswer())? count + 1: count;

                        } else if (radioButton4.isChecked()) {
                            count = listTopic.get(getCurrentquestion).getQ4().equals(listTopic.get(getCurrentquestion).getAnswer())? count + 1: count;

                        }
                        getCurrentquestion++;
                    if(getCurrentquestion > listTopic.size() - 1){
                        bindingScores();
                        bindingCorrectQuestion(count);
                        Navigation.findNavController(view).navigate(R.id.action_screen3_to_screen4);

                    }else {
                            setQuestionScreen(getCurrentquestion);
                        }
                }
            }
        });

    }

    private void bindingCorrectQuestion(int correcquestion) {
        ItemViewModel itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        itemViewModel.setCorrectQuestion(correcquestion);
    }


    private void bindingScores() {

        ItemViewModel itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        if(MainActivity.getLevel() == 1){
            totalScores = totalScores + (count *2);
            itemViewModel.setScores(totalScores);
        }
        else{
            totalScores = totalScores + count;
            itemViewModel.setScores(totalScores);
        }

    }

    private void getLevelTopic() {
        if(MainActivity.getLevel() == 1){
            loadAlldiffQuestion();
        }
        else{
            loadAlleasyQuestion();
        }
    }


    private void loadAlldiffQuestion() {
        if(String.valueOf(SelectedTopic).equals("khoa hoc")){
            getScienceTopicHard();
        }
        else if(String.valueOf(SelectedTopic).equals("nghe thuat")) {
            getArtTopicHard();
        }
        else if(String.valueOf(SelectedTopic).equals("lich su")) {
            getHistoryTopicHard();

        }
        else{
            getGeographyTopicHard();
        }
    }

    private void getGeographyTopicHard() {
        String jsonQuiz = loadJsonFromAsset("difficultQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("DifficultGeography");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }
    }

    private void getHistoryTopicHard() {
        String jsonQuiz = loadJsonFromAsset("difficultQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("DifficultHistory");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }

    }

    private void getArtTopicHard() {
        String jsonQuiz = loadJsonFromAsset("difficultQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("DifficultArt");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }

    }

    private void getScienceTopicHard() {
        String jsonQuiz = loadJsonFromAsset("difficultQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("DifficultScience");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }
    }


    private void loadAlleasyQuestion() {
        if(String.valueOf(SelectedTopic).equals("khoa hoc")){
                 getScienceTopic();
        }
        else if(String.valueOf(SelectedTopic).equals("nghe thuat")) {
                getArtTopic();
        }
        else if(String.valueOf(SelectedTopic).equals("lich su")) {
                getHistoryTopic();

        }
        else{
                getGeographyTopic();
        }
                }

    private void getGeographyTopic() {
        String jsonQuiz = loadJsonFromAsset("easyQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("easyQuestionGeography");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }
    }

    private void getHistoryTopic() {
        String jsonQuiz = loadJsonFromAsset("easyQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("easyQuestionHistory");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }
    }

    private void getArtTopic() {
        String jsonQuiz = loadJsonFromAsset("easyQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("easyQuestionArt");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }
    }

    private void getScienceTopic() {
        String jsonQuiz = loadJsonFromAsset("easyQuestion.json");
        listTopic = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray uerArray = jsonObject.getJSONArray("easyQuestionScience");
            Log.d("arrrarrrrry", uerArray.toString());
            for (int i = 0; i < uerArray.length(); i++) {
                JSONObject topic = uerArray.getJSONObject(i);
                String questionString = topic.getString("question");
                String answerA = topic.getString("answerA");
                String answerB = topic.getString("answerB");
                String answerC = topic.getString("answerC");
                String answerD = topic.getString("answerD");
                String correctAns = topic.getString("correct");
                listTopic.add(new DataQuestionTopic(questionString, answerA, answerB, answerC, answerD, correctAns));
                Log.d("cienceeeee", listTopic.toString());
            }
        }
        catch (JSONException e) {
            Log.d("abcdfgh", "Failed");
        }
    }



    private void setQuestionScreen(int currentQuestions) {
        question.setText(listTopic.get(currentQuestions).getTextViewQuestion());
        radioButton1.setText(listTopic.get(currentQuestions).getQ1());
        radioButton2.setText(listTopic.get(currentQuestions).getQ2());
        radioButton3.setText(listTopic.get(currentQuestions).getQ3());
        radioButton4.setText(listTopic.get(currentQuestions).getQ4());

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