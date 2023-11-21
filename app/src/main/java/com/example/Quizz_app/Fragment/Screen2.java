package com.example.Quizz_app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.Quizz_app.Adapter.DataProduct;
import com.example.Quizz_app.Adapter.ListQuestionAdapter;
import com.example.Quizz_app.Adapter.SetOnclickedForAnItem;
import com.example.constraint_layout.R;

import java.util.ArrayList;
import java.util.Set;

public class Screen2 extends Fragment {
    RecyclerView recyclerView;

    ArrayList<DataProduct> arrayList;

    ListQuestionAdapter listQuestionAdapter;

    Switch btnLevel;

    int flag;



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
                showToast( "Ban da chon chu de " + dataProduct.getTopic());
                //Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen3);
            }
        });

        recyclerView.setAdapter(listQuestionAdapter);

        btnLevel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag += 1;
            }
        });

    }

    private void showToast(String abc) {
        Toast.makeText(getContext(), abc ,Toast.LENGTH_SHORT).show();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen2, container, false);
    }

}


