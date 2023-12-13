package com.example.Quizz_app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Quizz_app.Activity.MainActivity;
import com.example.Quizz_app.Data.DataListQuestion;
import com.example.Quizz_app.Data.DataProduct;
import com.example.Quizz_app.Data.DataQuestionTopic;
import com.example.constraint_layout.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Screen6 extends Fragment {

    List<DataQuestionTopic> dataQuestionTopics;

    TextView question;

    TextView answer1, answer2, answer3, answer4;

    TextView levelQuestion;

    TextView Answer;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question = view.findViewById(R.id.textView_Question);
        levelQuestion = view.findViewById(R.id.textView_levelAnswer);
        Answer = view.findViewById(R.id.textView_textAnswer);
        answer1 = view.findViewById(R.id.answer1);
        answer2 = view.findViewById(R.id.answer2);
        answer3 = view.findViewById(R.id.answer3);
        answer4 = view.findViewById(R.id.answer4);

        getLevel();
        loadQuestion();
        setAnswer(0);


    }

    private void setAnswer(int a) {
        question.setText(MainActivity.getAnswer());
        answer1.setText(dataQuestionTopics.get(a).getQ1());
        answer2.setText(dataQuestionTopics.get(a).getQ2());
        answer3.setText(dataQuestionTopics.get(a).getQ3());
        answer4.setText(dataQuestionTopics.get(a).getQ4());
        Answer.setText(dataQuestionTopics.get(a).getAnswer());
    }

    private void getLevel() {

            MainActivity.getId();

            if(MainActivity.getId() % 2 == 0){
                levelQuestion.setText("Easy");
            }
            else{
                levelQuestion.setText("Hard");
            }

    }

    private void loadQuestion() {
        String topic =  MainActivity.getTopic();

        if(topic.equals("Khoa hoc")){
            if(MainActivity.getId() % 2 == 0){
                loadAnswerScienceEasy();
            }
            else{
                loadAnswerScienceHard();
            }
        }

        else if(topic.equals("Nghe thuat")){
            if(MainActivity.getId() % 2 == 0){
                loadAnswerArtEasy();
            }
            else{
                loadAnswerArtHard();
            }
        }

        else if(topic.equals("Dia ly")){
            if(MainActivity.getId() % 2 == 0){
                loadAnswerGeoEasy();
            }
            else{
                loadAnswerGeoHard();
            }
        }
        else{
            if(MainActivity.getId() % 2 == 0){
                loadAnswerHisEasy();
            }
            else{
                loadAnswerHisHard();
            }
        }
        Log.d("cvvvvv", dataQuestionTopics.toString());

    }

    private void loadAnswerHisHard() {
        String json = loadJsonFromAssert("difficultQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("DifficultHistory");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerHisEasy() {
        String json = loadJsonFromAssert("easyQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("easyQuestionHistory");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerGeoHard() {
        String json = loadJsonFromAssert("difficultQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("DifficultGeography");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerGeoEasy() {
        String json = loadJsonFromAssert("easyQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("easyQuestionGeography");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerArtHard() {
        String json = loadJsonFromAssert("difficultQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("DifficultArt");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerArtEasy() {
        String json = loadJsonFromAssert("easyQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("easyQuestionArt");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerScienceHard() {
        String json = loadJsonFromAssert("difficultQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("DifficultScience");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadAnswerScienceEasy() {
        String json = loadJsonFromAssert("easyQuestion.json");
        dataQuestionTopics = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("easyQuestionScience");
            int i = 0;
            while(i < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if(MainActivity.getAnswer().equals(jsonObject1.getString("question"))){
                    String a = jsonObject1.getString("answerA");
                    String b = jsonObject1.getString("answerB");
                    String c = jsonObject1.getString("answerC");
                    String d = jsonObject1.getString("answerD");
                    String abcd = jsonObject1.getString("correct");
                    dataQuestionTopics.add(new DataQuestionTopic(MainActivity.getAnswer(),a ,b,c, d, abcd));
                }
                i++;
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }



    private String loadJsonFromAssert(String s) {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen6, container, false);
    }
}