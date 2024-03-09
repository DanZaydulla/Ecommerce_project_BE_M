package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();
    Item findById(int id);
    int save(Item item);
    int update(Item item);
    int deleteById(int id);
}

