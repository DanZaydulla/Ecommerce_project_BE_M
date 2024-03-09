package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Item;
import com.example.Ecommerce_project_BE.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item item) {
        itemRepository.save(item);
        return item;
    }

    @Override
    public Item update(Item item) {
        itemRepository.update(item);
        return item;
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }
}
