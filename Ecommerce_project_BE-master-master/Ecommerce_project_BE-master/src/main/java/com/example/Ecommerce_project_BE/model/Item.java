package com.example.Ecommerce_project_BE.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    @JsonProperty("item_id")
    private Integer itemId;
    @JsonProperty("title")
    private String title;

    @JsonProperty("photo_url")
    private String photoUrl;


    private Double price;

    private Integer Quantity;

    public Item(Integer itemId, String title, String photoUrl, Double price, Integer Quantity) {
        this.itemId = itemId;
        this.title = title;
        this.photoUrl = photoUrl;
        this.price = price;
        this.Quantity = Quantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setStockQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }
}
