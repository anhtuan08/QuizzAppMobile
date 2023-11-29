package com.example.Quizz_app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.Quizz_app.Activity.MainActivity;
import com.example.Quizz_app.Adapter.SetListQuestionOnScreenAdapter;
import com.example.Quizz_app.Data.DataListQuestion;
import com.example.constraint_layout.R;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Screen5 extends Fragment {

    TextView singleQuestion;
    List<DataListQuestion> listQuestionInlist;

    SetListQuestionOnScreenAdapter setListQuestionOnScreenAdapter;

    RecyclerView recyclerView;

    AutoCompleteTextView autoCompleteTextView;

    String[] topic = {"Khoa hoc", "Nghe thuat", "Dia ly", "Lich su"};

    ArrayAdapter<String> arrayAdapter;
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        singleQuestion = view.findViewById(R.id.textView_singleQuestion);
        recyclerView = view.findViewById(R.id.recycleView_listQuestion);
        autoCompleteTextView =  view.findViewById(R.id.spinnerTopic);

        arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_item, topic);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String abc = parent.getItemAtPosition(position).toString();
                if(abc.equals("Khoa hoc")){
                    loadScienceQuestion();
                } else if (abc.equals("Nghe thuat")) {
                    loadArtQuestion();
                } else if (abc.equals("Dia ly")) {
                    loadGeoQuestion();
                }
                else{
                    loadHisQuestion();
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setListQuestionOnScreenAdapter = new SetListQuestionOnScreenAdapter(listQuestionInlist);
        recyclerView.setAdapter(setListQuestionOnScreenAdapter);

            }
        });
    }

    private void loadHisQuestion() {
        String jsonQuiz1 = loadJsonFromAsset("easyQuestion.json");
        String jsonQuiz2 = loadJsonFromAsset("difficultQuestion.json");
        listQuestionInlist = new ArrayList<>();


        try {
            JSONObject jsonObject1 = new JSONObject(jsonQuiz1);
            JSONObject jsonObject2 = new JSONObject(jsonQuiz2);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("easyQuestionHistory");
            JSONArray jsonArray2= jsonObject2.getJSONArray("DifficultHistory");
            for(int i = 0; i < jsonArray1.length(); i++){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
            }
            for (int j = 0; j< jsonArray2.length(); j++){
                JSONObject object2 = jsonArray2.getJSONObject(j);
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(hardQuestion));
            }
        } catch (JSONException e) {
            Log.d("danh sach cau hoi", listQuestionInlist.toString());
        }
    }

    private void loadGeoQuestion() {
        String jsonQuiz1 = loadJsonFromAsset("easyQuestion.json");
        String jsonQuiz2 = loadJsonFromAsset("difficultQuestion.json");
        listQuestionInlist = new ArrayList<>();


        try {
            JSONObject jsonObject1 = new JSONObject(jsonQuiz1);
            JSONObject jsonObject2 = new JSONObject(jsonQuiz2);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("easyQuestionGeography");
            JSONArray jsonArray2= jsonObject2.getJSONArray("DifficultGeography");
            for(int i = 0; i < jsonArray1.length(); i++){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
            }
            for (int j = 0; j< jsonArray2.length(); j++){
                JSONObject object2 = jsonArray2.getJSONObject(j);
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(hardQuestion));
            }
        } catch (JSONException e) {
            Log.d("danh sach cau hoi", listQuestionInlist.toString());
        }
    }

    private void loadArtQuestion() {
        String jsonQuiz1 = loadJsonFromAsset("easyQuestion.json");
        String jsonQuiz2 = loadJsonFromAsset("difficultQuestion.json");
        listQuestionInlist = new ArrayList<>();


        try {
            JSONObject jsonObject1 = new JSONObject(jsonQuiz1);
            JSONObject jsonObject2 = new JSONObject(jsonQuiz2);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("easyQuestionArt");
            JSONArray jsonArray2= jsonObject2.getJSONArray("DifficultArt");
            for(int i = 0; i < jsonArray1.length(); i++){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
            }
            for (int j = 0; j< jsonArray2.length(); j++){
                JSONObject object2 = jsonArray2.getJSONObject(j);
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(hardQuestion));
            }
        } catch (JSONException e) {
            Log.d("danh sach cau hoi", listQuestionInlist.toString());
        }
    }

    private void loadScienceQuestion() {
        String jsonQuiz1 = loadJsonFromAsset("easyQuestion.json");
        String jsonQuiz2 = loadJsonFromAsset("difficultQuestion.json");
        listQuestionInlist = new ArrayList<>();


        try {
            JSONObject jsonObject1 = new JSONObject(jsonQuiz1);
            JSONObject jsonObject2 = new JSONObject(jsonQuiz2);
            JSONArray jsonArray1 = jsonObject1.getJSONArray("easyQuestionScience");
            JSONArray jsonArray2= jsonObject2.getJSONArray("DifficultScience");
            for(int i = 0; i < jsonArray1.length(); i++){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
            }
            for (int j = 0; j< jsonArray2.length(); j++){
                JSONObject object2 = jsonArray2.getJSONObject(j);
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(hardQuestion));
            }
        } catch (JSONException e) {
            Log.d("danh sach cau hoi", listQuestionInlist.toString());
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

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen5, container, false);
    }
}