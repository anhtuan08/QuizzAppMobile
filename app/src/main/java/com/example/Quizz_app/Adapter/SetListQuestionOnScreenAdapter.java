package com.example.Quizz_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Quizz_app.Data.DataListQuestion;
import com.example.constraint_layout.R;

import java.util.List;

public class SetListQuestionOnScreenAdapter extends RecyclerView.Adapter<SetListQuestionOnScreenAdapter.MyViewHolder> {
    List<DataListQuestion> listQuestion;

    public SetListQuestionOnScreenAdapter(List<DataListQuestion> listQuestion) {
        this.listQuestion = listQuestion;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Anh xa Layout vao Adapter, moi khi mot phan tu moi duoc tao se tao ra mot MyViewHolder moi
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_question, parent, false);

        return new MyViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            //Truyen du lieu

        //Khai bao Data de tham chieu den cac phan tu trong Recycle View
        DataListQuestion dataListQuestion;

        //Lay cac phan tu bang mot mang: listQuestion, truyen tham so vao la vi tri
        dataListQuestion = listQuestion.get(position);

       holder.abc.setText(dataListQuestion.getListQuestion());
    }

    @Override
    public int getItemCount() {
        return listQuestion.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView abc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            abc = itemView.findViewById(R.id.textView_eachQuestion);
        }
    }
}
