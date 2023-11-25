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
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.Quizz_app.Activity.MainActivity;
import com.example.Quizz_app.Data.DataProduct;
import com.example.Quizz_app.Adapter.ListQuestionAdapter;
import com.example.Quizz_app.Adapter.SetOnclickedForAnItem;
import com.example.Quizz_app.ViewModel.ItemViewModel;
import com.example.constraint_layout.R;

import java.util.ArrayList;

public class Screen2 extends Fragment {
    RecyclerView recyclerView;

    ArrayList<DataProduct> arrayList;

    ListQuestionAdapter listQuestionAdapter;

    Switch btnLevel;

    Button btnListQuestion;

    int flag;

    String topic;

    ItemViewModel itemViewModel;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Recycle_View);
        btnLevel = view.findViewById(R.id.btnSwitch_level);
        btnListQuestion = view.findViewById(R.id.btnListQuestion);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = new ArrayList<>();

        arrayList.add(new DataProduct("khoa hoc", "Day la cac cau hoi ve chu de khoa hoc", R.drawable.science));
        arrayList.add(new DataProduct("nghe thuat", "Day la cac cau hoi ve chu de nghe thuat", R.drawable.art));
        arrayList.add(new DataProduct("lich su", "Day la cac cau hoi ve chu de lich su", R.drawable.history));
        arrayList.add(new DataProduct("dia ly", "Day la cac cau hoi ve chu de dia ly", R.drawable.geography));

        listQuestionAdapter = new ListQuestionAdapter(arrayList, new SetOnclickedForAnItem() {
            @Override
            public void onItemClicked(DataProduct dataProduct) {

                showToast( "Ban da chon chu de " + dataProduct.getTopic());
                topic = dataProduct.getTopic();

                getLevelQuestion();
                getTopicQuestion(topic);
                sendDataToActivity();
                Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen3);
            }

        });

        recyclerView.setAdapter(listQuestionAdapter);

        btnListQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen5);
            }
        });


    }

    private void getTopicQuestion(String s) {
    }

    private void sendDataToActivity() {
        itemViewModel =  new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        itemViewModel.setLevel(flag);
        itemViewModel.setTopic(topic);

        Log.d("chon topiccc", String.valueOf(itemViewModel.getTopic()));

    }

    private void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }


    private int getLevelQuestion() {
        if(btnLevel.isChecked()){
            flag++;
        }
        else {
            flag = 0;
        }
        return flag;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen2, container, false);
    }

}


