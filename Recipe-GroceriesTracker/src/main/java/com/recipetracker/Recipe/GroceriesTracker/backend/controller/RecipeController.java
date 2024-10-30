package com.recipetracker.Recipe.GroceriesTracker.backend.controller;

import com.recipetracker.Recipe.GroceriesTracker.backend.model.Recipe;
import com.recipetracker.Recipe.GroceriesTracker.backend.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Get all recipes
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    // Get a recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get a recipe by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Recipe> getRecipeByName(@PathVariable String name) {
        Optional<Recipe> recipe = recipeService.getRecipeByName(name);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get recipes ordered by rating (descending)
    @GetMapping("/rating/desc")
    public ResponseEntity<List<Recipe>> getRecipesByRatingDesc() {
        List<Recipe> recipes = recipeService.getRecipesByRatingDesc();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    // Get recipes ordered by rating (ascending)
    @GetMapping("/rating/asc")
    public ResponseEntity<List<Recipe>> getRecipesByRatingAsc() {
        List<Recipe> recipes = recipeService.getRecipesByRatingAsc();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    // Get recipes by specific rating
    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Recipe>> getRecipesBySpecificRating(@PathVariable int rating) {
        List<Recipe> recipes = recipeService.getRecipesBySpecificRating(rating);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    // Add a new recipe
    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    // Update an existing recipe
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable int id, @RequestBody Recipe recipeDetails) {
        try {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
            return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a recipe by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
