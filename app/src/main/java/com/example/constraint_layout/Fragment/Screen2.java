package com.example.constraint_layout.Fragment;

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
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.constraint_layout.Adapter.DataProduct;
import com.example.constraint_layout.Adapter.ListQuestionAdapter;
import com.example.constraint_layout.R;

import java.util.ArrayList;


public class Screen2 extends Fragment {
        RecyclerView recyclerView;

        ArrayList<DataProduct> arrayList;

        ListQuestionAdapter listQuestionAdapter;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Recycle_View);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = new ArrayList<>();

        arrayList.add(new DataProduct("khoa hoc", "day la khoa hoc", R.drawable.science));
        arrayList.add(new DataProduct("nghe thuat", "day la nghe thuat", R.drawable.art));
        arrayList.add(new DataProduct("Lich su", "day la lich su ", R.drawable.history));
        arrayList.add(new DataProduct("Dia ly", "day la dia ly", R.drawable.geography));

        listQuestionAdapter = new ListQuestionAdapter(arrayList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listQuestionAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_screen2_to_screen3);
            }
        });

    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen2, container, false);
    }
}