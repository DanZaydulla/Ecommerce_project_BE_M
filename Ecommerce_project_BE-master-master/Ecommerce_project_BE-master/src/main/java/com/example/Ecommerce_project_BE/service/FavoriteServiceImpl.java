package com.example.Ecommerce_project_BE.service;
import com.example.Ecommerce_project_BE.model.Favorite;
import com.example.Ecommerce_project_BE.repository.FavoriteRepository;
import com.example.Ecommerce_project_BE.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public Favorite addFavorite(Integer customerId, Integer itemId) {
        // Use the constructor with parameters instead of setting fields individually
        Favorite favorite = new Favorite(customerId, itemId);
        favoriteRepository.addFavorite(favorite);
        return favorite;
    }

    @Override
    public void removeFavorite(Integer customerId, Integer itemId) {
        favoriteRepository.removeFavorite(customerId, itemId);
    }

    @Override
    public List<Favorite> getFavoritesByCustomerId(Integer customerId) {
        return favoriteRepository.findFavoritesByCustomerId(customerId);
    }
}