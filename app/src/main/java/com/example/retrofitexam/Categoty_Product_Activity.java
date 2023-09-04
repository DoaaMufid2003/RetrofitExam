package com.example.retrofitexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.retrofitexam.Model.Add_Product_Request;
import com.example.retrofitexam.Model.Category_Product_Responce;
import com.example.retrofitexam.databinding.ActivityCategotyProductBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Categoty_Product_Activity extends AppCompatActivity {
    ActivityCategotyProductBinding binding;
    ApiServier apiServier;
    Category_Product_Responce category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategotyProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       apiServier= ApiServier.Retrofitclass.getRetrofitInstance();
       binding.img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               addproduct();
           }
       });
       apiServier.get_categorios_products("smartphones").enqueue(new Callback<Category_Product_Responce>() {
            @Override
            public void onResponse(Call<Category_Product_Responce> call, Response<Category_Product_Responce> response) {
                 category = response.body();
                ArrayList<Category_Product_Responce.Products> products = category.getProductsArrayList();
              //  Log.d("array",category.getProductsArrayList().get(2).getPrice());
                //products.add()
                Categoty_Product_Adapter adapter = new Categoty_Product_Adapter(products, getApplicationContext(), new ListenerInterface() {
                    @Override
                    public void onclick(int productId, int pos) {
                        Intent intent = new Intent(getApplicationContext(), Product_byId_Activity.class);
                        intent.putExtra("id", productId);
                        startActivity(intent);
                    }

                });

                binding.rv.setAdapter(adapter);
                binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));




            }

            @Override
            public void onFailure(Call<Category_Product_Responce> call, Throwable t) {

            }
        });
    }

    public void addproduct() {
        Category_Product_Responce.Products add_product_request = new Category_Product_Responce.Products("iphone 13", "Phone", "New iphone 13", "1000", "4.5", "Apple");
        add_product_request.setCategory("Phone");
        add_product_request.setBrand("Apple");
        add_product_request.setDescription("New iphone 13");
        add_product_request.setPrice("1000");
        add_product_request.setName("iphone 13");
        add_product_request.setRating("4.5");

        Category_Product_Responce.Products add_product_request1 = new Category_Product_Responce.Products(add_product_request.getName(), add_product_request.getCategory(), add_product_request.getDescription(), add_product_request.getPrice(), add_product_request.getRating(), add_product_request.getBrand());

        apiServier.Add_Products(add_product_request1).enqueue(new Callback<Category_Product_Responce>() {
            @Override
            public void onResponse(Call<Category_Product_Responce> call, Response<Category_Product_Responce> response) {

//               category= response.body();
             category.getProductsArrayList().add(add_product_request1);
            }

            @Override
            public void onFailure(Call<Category_Product_Responce> call, Throwable t) {
            t.printStackTrace();
            }
        });
    }


}