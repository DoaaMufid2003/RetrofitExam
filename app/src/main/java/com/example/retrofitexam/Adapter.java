package com.example.retrofitexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.retrofitexam.databinding.CustomitemBinding;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends  RecyclerView.Adapter<Adapter.ViewHolder>{
List<String> stringList;
Context context;
Lesitner lesitner;


    public Adapter(List<String> stringList, Context context, Lesitner lesitner) {
        this.stringList = stringList;
        this.context = context;
        this.lesitner = lesitner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomitemBinding binding=CustomitemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setText(stringList.get(position).toString());

            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lesitner.Onclick(holder.button.getText().toString());
                }
            });


    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

Button button;

        public ViewHolder(@NonNull CustomitemBinding binding) {
            super(binding.getRoot());
           button=binding.button;

        }
    }
}
