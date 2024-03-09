package com.example.Ecommerce_project_BE.controller;
import com.example.Ecommerce_project_BE.model.Favorite;
import com.example.Ecommerce_project_BE.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // Endpoint to add an item to favorites
    @PostMapping("/add")
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        try {
            Favorite newFavorite = favoriteService.addFavorite(favorite.getCustomerId(), favorite.getItemId());
            return ResponseEntity.ok(newFavorite);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint to remove an item from favorites
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFavorite(@RequestParam int customerId, @RequestParam int itemId) {
        try {
            favoriteService.removeFavorite(customerId, itemId);
            return ResponseEntity.ok("Favorite item removed successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error removing favorite item: " + e.getMessage());
        }
    }

    // Endpoint to get all favorite items for a customer
    @GetMapping("/{customerId}")
    public ResponseEntity<List<Favorite>> getFavoritesByCustomerId(@PathVariable int customerId) {
        try {
            List<Favorite> favorites = favoriteService.getFavoritesByCustomerId(customerId);
            return ResponseEntity.ok(favorites);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}