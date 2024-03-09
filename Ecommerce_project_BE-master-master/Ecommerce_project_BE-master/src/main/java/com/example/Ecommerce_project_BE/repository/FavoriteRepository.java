package com.example.Ecommerce_project_BE.repository;

import com.example.Ecommerce_project_BE.model.Favorite;

import java.util.List;

public interface FavoriteRepository {
    void addFavorite(Favorite favorite);
    void removeFavorite(Integer customerId, Integer itemId);
    List<Favorite> findFavoritesByCustomerId(Integer customerId);
}
