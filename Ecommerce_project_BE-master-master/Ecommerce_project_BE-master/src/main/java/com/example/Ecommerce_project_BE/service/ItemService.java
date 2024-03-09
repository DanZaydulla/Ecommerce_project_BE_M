package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    Item findById(int id);
    Item save(Item item);
    Item update(Item item);
    void deleteById(int id);
}
