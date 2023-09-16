package com.example.retrofitexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.retrofitexam.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<String> list = new ArrayList<>();
        ApiServier.Retrofitclass.getRetrofitInstance().categories().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Adapter adapter = new Adapter(response.body(), getApplicationContext(), new Lesitner() {
                    @Override
                    public void Onclick(String categoryname) {
                        Intent intent=new Intent(getApplicationContext(), Categoty_Product_Activity.class);
                        intent.putExtra("name", categoryname);
                        startActivity(intent);
                    }

                    @Override
                    public void Onclick() {
                        startActivity(new Intent(getApplicationContext(), Categoty_Product_Activity.class));
                    }
                });
                binding.rv.setAdapter(adapter);
                binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });


    }
}