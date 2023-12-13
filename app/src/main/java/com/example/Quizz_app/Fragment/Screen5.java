package com.example.Quizz_app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.Quizz_app.Adapter.SetListQuestionOnScreenAdapter;
import com.example.Quizz_app.Adapter.SetOnclickedForAnAnswer;
import com.example.Quizz_app.Data.DataListQuestion;
import com.example.Quizz_app.ViewModel.ItemViewModel;
import com.example.constraint_layout.R;

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

    ItemViewModel itemViewModel;

    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        singleQuestion = view.findViewById(R.id.textView_singleQuestion);
        recyclerView = view.findViewById(R.id.recycleView_listQuestion);
        autoCompleteTextView =  view.findViewById(R.id.spinnerTopic);

        arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.list_item, topic);

        autoCompleteTextView.setAdapter(arrayAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
                sendTopic(abc);
                setListQuestionOnScreenAdapter = new SetListQuestionOnScreenAdapter(listQuestionInlist, new SetOnclickedForAnAnswer() {
                    @Override
                    public void onItemClicked(DataListQuestion dataListQuestion) {
                        Toast.makeText(getContext(), "Cau tra loi la: " , Toast.LENGTH_SHORT).show();
                        sendQuestion(dataListQuestion.getListQuestion(), dataListQuestion.getId());
                        changeToAnswerScreen();
                    }
                });
                     recyclerView.setAdapter(setListQuestionOnScreenAdapter);
            }

            private void sendTopic(String s) {
                 itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
                 itemViewModel.setTopic(s);
            }

            private void changeToAnswerScreen() {
                Navigation.findNavController(view).navigate(R.id.action_screen5_to_screen69);
            }
        });
    }

    private void sendQuestion(String s, int a) {
        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        itemViewModel.setAnswer(s.toString());
        itemViewModel.setId(a);


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
            for(int i = 0; i < jsonArray1.length() + jsonArray2.length(); i+= 2){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                JSONObject object2 = jsonArray2.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion,i));
                listQuestionInlist.add(new DataListQuestion(hardQuestion,i+1));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
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
            for(int i = 0; i < jsonArray1.length() + jsonArray2.length(); i+= 2){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                JSONObject object2 = jsonArray2.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion,i));
                listQuestionInlist.add(new DataListQuestion(hardQuestion,i+1));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
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
            for(int i = 0; i < jsonArray1.length() + jsonArray2.length(); i+= 2){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                JSONObject object2 = jsonArray2.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion,i));
                listQuestionInlist.add(new DataListQuestion(hardQuestion,i+1));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
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
            for(int i = 0; i < jsonArray1.length() + jsonArray2.length(); i+= 2){
                JSONObject object1 = jsonArray1.getJSONObject(i);
                JSONObject object2 = jsonArray2.getJSONObject(i);
                String easyQuestion = object1.getString("question");
                String hardQuestion = object2.getString("question");
                listQuestionInlist.add(new DataListQuestion(easyQuestion,i));
                listQuestionInlist.add(new DataListQuestion(hardQuestion,i+1));
                Log.d("listQuestionInlist", listQuestionInlist.toString());
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