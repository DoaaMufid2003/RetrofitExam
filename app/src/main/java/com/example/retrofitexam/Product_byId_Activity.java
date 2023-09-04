package com.example.retrofitexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.retrofitexam.Model.Category_Product_Responce;
import com.example.retrofitexam.databinding.ActivityProductByIdBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product_byId_Activity extends AppCompatActivity {
ActivityProductByIdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductByIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       Intent intent= getIntent();
     int id=  intent.getIntExtra("id",0);
    ApiServier.Retrofitclass.getRetrofitInstance().get_products_byId(id).enqueue(new Callback<Category_Product_Responce.Products>() {
        @Override
        public void onResponse(Call<Category_Product_Responce.Products> call, Response<Category_Product_Responce.Products> response) {
           Category_Product_Responce.Products products= response.body();
         binding.tvPrice.setText(products.getPrice());
         binding.tvTitle.setText(products.getTitle());
         binding.img.setImageURI(Uri.parse(products.getThumbnail()));
        }

        @Override
        public void onFailure(Call<Category_Product_Responce.Products> call, Throwable t) {
        t.printStackTrace();
        }
    });
    }
}