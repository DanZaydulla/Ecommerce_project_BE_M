package com.example.Ecommerce_project_BE.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Favorite {
    @JsonProperty("customer_Id")
    private int customerId;

    @JsonProperty("item_Id")
    private int itemId;
    private List<Item>  Item ;


    public Favorite(int customerId, int itemId) {
        this.customerId = customerId;
        this.itemId = itemId;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
