package com.example.retrofitexam;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitexam.Model.Category_Product_Responce;
import com.example.retrofitexam.databinding.CategoryProductCustomBinding;
import com.example.retrofitexam.databinding.CustomitemBinding;

import java.util.ArrayList;


public class Categoty_Product_Adapter extends  RecyclerView.Adapter<Categoty_Product_Adapter.ViewHolder> {
ArrayList<Category_Product_Responce.Products>productsArrayList;
Context context;
ListenerInterface listenerInterface;

    public Categoty_Product_Adapter(ArrayList<Category_Product_Responce.Products> productsArrayList, Context context, ListenerInterface listenerInterface) {
        this.productsArrayList = productsArrayList;
        this.context = context;
        this.listenerInterface = listenerInterface;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryProductCustomBinding binding=CategoryProductCustomBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Categoty_Product_Adapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Category_Product_Responce.Products products=productsArrayList.get(position);
        if (products==null){
            return;
        }else {
            Glide.with(context).load(products.getThumbnail()).optionalCircleCrop().into(holder.imageView);
            holder.disciption.setText(products.getDescription());
            holder.title.setText(products.getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerInterface.onclick(products.getId(),holder.getAdapterPosition());
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView disciption,title;
        ImageView imageView;

        public ViewHolder(@NonNull CategoryProductCustomBinding binding) {
            super(binding.getRoot());
          title=binding.tvTitle;
          disciption=binding.tvDiscreption;
          imageView=binding.img;

        }
    }
}
