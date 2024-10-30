package com.recipetracker.Recipe.GroceriesTracker.backend.service;

import com.recipetracker.Recipe.GroceriesTracker.backend.model.Recipe;
import com.recipetracker.Recipe.GroceriesTracker.backend.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // Get all recipes
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    // Get a recipe by ID
    public Optional<Recipe> getRecipeById(int id) {
        return recipeRepository.findById(id);
    }

    // Get a recipe by name
    public Optional<Recipe> getRecipeByName(String name) {
        return recipeRepository.findByRecipeName(name);
    }

    // Get recipes ordered by rating (descending)
    public List<Recipe> getRecipesByRatingDesc() {
        return recipeRepository.findAllByOrderByRatingDesc();
    }

    // Get recipes ordered by rating (ascending)
    public List<Recipe> getRecipesByRatingAsc() {
        return recipeRepository.findAllByOrderByRatingAsc();
    }

    // Get recipes by specific rating
    public List<Recipe> getRecipesBySpecificRating(int rating) {
        return recipeRepository.findRecipeByRating(rating);
    }

    // Add a new recipe
    public Recipe addRecipe(Recipe recipe) {
        recipe.setDateAdded(java.sql.Date.valueOf(java.time.LocalDate.now())); // Set the current date
        return recipeRepository.save(recipe);
    }

    // Update an existing recipe
    public Recipe updateRecipe(int id, Recipe recipeDetails) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            recipe.setRecipeName(recipeDetails.getRecipeName());
            recipe.setRecipeImage(recipeDetails.getRecipeImage());
            recipe.setRecipeInstructions(recipeDetails.getRecipeInstructions());
            recipe.setRecipeVideo(recipeDetails.getRecipeVideo());
            recipe.setServingSize(recipeDetails.getServingSize());
            recipe.setRating(recipeDetails.getRating());
            return recipeRepository.save(recipe);
        } else {
            throw new RuntimeException("Recipe not found with id " + id);
        }
    }

    // Delete a recipe by ID
    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }
}
