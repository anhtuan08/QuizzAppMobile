package com.example.Quizz_app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.Quizz_app.Adapter.DataProduct;
import com.example.Quizz_app.Adapter.ListQuestionAdapter;
import com.example.Quizz_app.Adapter.SetOnclickedForAnItem;
import com.example.constraint_layout.R;

import java.util.ArrayList;

public class Screen2 extends Fragment {
    RecyclerView recyclerView;

    ArrayList<DataProduct> arrayList;

    ListQuestionAdapter listQuestionAdapter;

    Switch btnLevel;

    int flag;

    int art, geo, his , scien;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Recycle_View);
        btnLevel = view.findViewById(R.id.btnSwitch_level);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = new ArrayList<>();

        arrayList.add(new DataProduct("khoa hoc", "day la khoa hoc", R.drawable.science));
        arrayList.add(new DataProduct("nghe thuat", "day la nghe thuat", R.drawable.art));
        arrayList.add(new DataProduct("Lich su", "day la lich su ", R.drawable.history));
        arrayList.add(new DataProduct("Dia ly", "day la dia ly", R.drawable.geography));

        listQuestionAdapter = new ListQuestionAdapter(arrayList, new SetOnclickedForAnItem() {
            @Override
            public void onItemClicked(DataProduct dataProduct) {
                if(dataProduct.getTopic().equals("khoa hoc")){
                    scien ++;
                }
                else if (dataProduct.getTopic().equals("nghe thuat"))
                {
                    art++;
                } else if (dataProduct.getTopic().equals("Lich su")) {
                    his++;
                } else if (dataProduct.getTopic().equals("Dia ly")) {
                    geo++;
                }
                showToast( "Ban da chon chu de " + dataProduct.getTopic());
                //Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen3);
                getLevelQuestion();
                getTopicQuestion(scien, art, his, geo);
                //Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen3);
            }

        });

        recyclerView.setAdapter(listQuestionAdapter);


    }

    private void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    private void getTopicQuestion(int a, int b, int c, int d) {
        if(a == 1)
        {
            Bundle bundle = new Bundle();
            bundle.putString("a", "science");
            getParentFragmentManager().setFragmentResult("abcd", bundle);
        }
        else if (b == 1){
            Bundle bundle = new Bundle();
            bundle.putString("a", "art");
            getParentFragmentManager().setFragmentResult("abcd", bundle);
        }
        else if (c == 1){
            Bundle bundle = new Bundle();
            bundle.putString("a", "his");
            getParentFragmentManager().setFragmentResult("abcd", bundle);
        }
        else if (d == 1){
            Bundle bundle = new Bundle();
            bundle.putString("a", "geo");
            getParentFragmentManager().setFragmentResult("abcd", bundle);
        }
    }


    private void getLevelQuestion() {
        if(btnLevel.isChecked()){
            flag++;
        }
        else {
            flag = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("lua chon cau hoi", flag);
        getParentFragmentManager().setFragmentResult("ChangeLevel", bundle);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen2, container, false);
    }

}


