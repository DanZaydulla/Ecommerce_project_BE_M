package com.example.Ecommerce_project_BE.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderRequest {
    @JsonProperty("customer_id")
    private Integer customerId;
    private Order order;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("total_price")
    private Double totalPrice;
    @JsonProperty("item_id")
    private Integer itemId;
    private Integer Quantity;

    public OrderRequest(Integer customerId, Order order, Double price, Double totalPrice, Integer itemId, Integer quantity) {
        this.customerId = customerId;
        this.order = order;
        this.price = price;
        this.totalPrice = totalPrice;
        this.itemId = itemId;
        Quantity = quantity;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}