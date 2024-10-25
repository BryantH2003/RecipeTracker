package com.recipetracker.Recipe.GroceriesTracker.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipetracker.Recipe.GroceriesTracker.backend.model.Ingredient;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    // Find Ingredient by Name
    Optional<Ingredient> findByIngredientName(String name);
}
