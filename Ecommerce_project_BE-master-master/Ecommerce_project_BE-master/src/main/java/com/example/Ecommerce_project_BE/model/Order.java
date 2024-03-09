package com.example.Ecommerce_project_BE.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Order {
    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("total_price")
    private Double totalPrice;

    @JsonProperty("status")
    private Status status;

    public Order(Integer orderId, Integer customerId, LocalDate orderDate, String shippingAddress, Double totalPrice, Status status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
