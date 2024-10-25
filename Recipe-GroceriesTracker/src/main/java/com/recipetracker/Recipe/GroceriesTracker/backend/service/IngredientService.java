package com.recipetracker.Recipe.GroceriesTracker.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipetracker.Recipe.GroceriesTracker.backend.model.Ingredient;
import com.recipetracker.Recipe.GroceriesTracker.backend.repository.IngredientRepository;

@Service
public class IngredientService {
    @Autowired
    IngredientRepository repository;

    public Ingredient getIngredientByID(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ingredient ID not found"));
    }

    public Iterable<Ingredient> getAllIngredient() {
        return repository.findAll();
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public Ingredient editIngredientAmt(Ingredient ingredient, int change) {
        ingredient.editIngredientAmt(change);
        return repository.save(ingredient);
    }

    public Ingredient deleteIngredientByID(int id) {
        Ingredient ingredient = getIngredientByID(id); // Validates existence
        repository.deleteById(id);
        return ingredient;
    }
}
