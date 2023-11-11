package com.example.constraint_layout.Adapter;

import static java.security.AccessController.getContext;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.constraint_layout.R;

import java.util.ArrayList;
import java.util.List;

public class ListQuestionAdapter extends RecyclerView.Adapter<ListQuestionAdapter.MyViewHolder>{

    private List<DataProduct> dataProducts;

    public ListQuestionAdapter(List<DataProduct> dataProducts) {
        this.dataProducts = dataProducts;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTopic;
        TextView descriptionTopic;
        ImageView imageTopic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //anh xa, su dung itemView de anh xa sang tung phan tu
            nameTopic = itemView.findViewById(R.id.textView_nameTopic);
            descriptionTopic = itemView.findViewById(R.id.textView_descriptionTopic);
            imageTopic = itemView.findViewById(R.id.image_topic);

            //lay tai nguyen

        }

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // nap layout cua tung phan tu cho Recycled View
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //Khai bao mot phan tu view la item cua tung Topic. Ham oncreateViewHolder khoi tao ra de nap layout vao cho mot list view
        //Layout duoc nap la tung topic rieng le
        View itemTopic = inflater.inflate(R.layout.list_topic, parent, false);

        itemTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_screen2_to_screen3);
            }
        });

        //Tra ve mot phan tu moi cua MyViewHolder
        return new MyViewHolder(itemTopic);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Nap du lieu vao cho Recycled View, su dung Get, Set

        //Su dung du lieu la Data Product
        DataProduct dataProduct;

        //Lay vi tri cua tung phan tu trong List voi tham chieu truyen vao la dataProducts
        dataProduct = dataProducts.get(position);

        holder.nameTopic.setText(dataProduct.topic);
        holder.descriptionTopic.setText(dataProduct.decriptionTopic);
        holder.imageTopic.setImageResource(dataProduct.imageTopic);

    }

    @Override
    public int getItemCount() {
        // Dem so luong phan tu

        return dataProducts.size();
    }

}
