package com.example.retrofitexam.Model;

public class Add_Product_Request {
    String name;
    String category;
    String description;
    String price;
    String rating;
    String brand;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public Add_Product_Request(String name, String category, String description, String price, String rating, String brand) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.brand = brand;

    }
}
