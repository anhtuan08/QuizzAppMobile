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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.Quizz_app.Adapter.ListQuestionAdapter;
import com.example.Quizz_app.Adapter.SetListQuestionOnScreenAdapter;
import com.example.Quizz_app.Data.DataListQuestion;
import com.example.Quizz_app.Data.DataProduct;
import com.example.constraint_layout.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Screen5 extends Fragment {

    TextView abc;
    List<DataListQuestion> listQuestionInlist;

    SetListQuestionOnScreenAdapter setListQuestionOnScreenAdapter;

    RecyclerView recyclerView;

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> arrayAdapter;


    String[] topic = {"khoa hoc, dia ly, lich su, nghe thuat"};

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        abc = view.findViewById(R.id.textView_eachQuestion);
        recyclerView = view.findViewById(R.id.recycleView_listQuestion);
        autoCompleteTextView = view.findViewById(R.id.autoComplete_Topic);

        arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.list_question);

        autoCompleteTextView.setAdapter(arrayAdapter);


        String jsonQuiz = loadJsonFromAsset("easyQuestion.json");
        listQuestionInlist = new ArrayList<>();


        try {
            JSONObject jsonObject = new JSONObject(jsonQuiz);
            JSONArray jsonArray = jsonObject.getJSONArray("easyQuestionArt");
            for(int i = 0; i < jsonArray.length(); i++){
                 JSONObject object = jsonArray.getJSONObject(i);
                 String abc = object.getString("question");
                 listQuestionInlist.add(new DataListQuestion(abc));
                 Log.d("listQuestionInlist", listQuestionInlist.toString());
            }

        } catch (JSONException e) {
            Log.d("danh sach cau hoi", listQuestionInlist.toString());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setListQuestionOnScreenAdapter = new SetListQuestionOnScreenAdapter(listQuestionInlist);
        Log.d("setListQuestionOnScreenAdapter", setListQuestionOnScreenAdapter.toString());
        recyclerView.setAdapter(setListQuestionOnScreenAdapter);


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