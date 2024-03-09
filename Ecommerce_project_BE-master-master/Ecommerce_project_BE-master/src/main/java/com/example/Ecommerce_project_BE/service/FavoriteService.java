package com.example.Ecommerce_project_BE.service;

import com.example.Ecommerce_project_BE.model.Favorite;

import java.util.List;

public interface FavoriteService {

    Favorite addFavorite(Integer customerId, Integer itemId);
    void removeFavorite(Integer customerId, Integer itemId);
    List<Favorite> getFavoritesByCustomerId(Integer customerId);

}
