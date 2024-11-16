package com.example.midtermapp;

public class WishlistModal {
    //these are the variables for our product name, brand name, and price
    private String productName;
    private String brandName;
    private String price;
    private  int id;

    //getter and setter methods

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WishlistModal(String productName, String brandName, String price) {
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
    }
}
