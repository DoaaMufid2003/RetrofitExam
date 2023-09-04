package com.example.retrofitexam.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Category_Product_Responce {
    @SerializedName("products")
ArrayList<Products> productsArrayList;
    @SerializedName("id")
    int id;

    public Category_Product_Responce() {
    }

    public ArrayList<Products> getProductsArrayList() {
        return productsArrayList;
    }

    public void setProductsArrayList(ArrayList<Products> productsArrayList) {
        this.productsArrayList = productsArrayList;
    }

    public static class Products{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @SerializedName("id")
         int id;
        @SerializedName("title")
        String title;
        @SerializedName("description")
        String description;
        @SerializedName("thumbnail")
        String thumbnail;
        @SerializedName("price")
        String price;
        @SerializedName("name")
        String name;
        @SerializedName("category")
        String category;
        @SerializedName("rating")
        String rating;
        @SerializedName("brand")
        String brand;

        public Products(String name, String category, String description, String price, String rating, String brand) {
            this.description = description;
            this.price = price;
            this.name = name;
            this.category = category;
            this.rating = rating;
            this.brand = brand;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Products() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
}
