package com.recipetracker.Recipe.GroceriesTracker.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recipetracker.Recipe.GroceriesTracker.backend.model.Ingredient;
import com.recipetracker.Recipe.GroceriesTracker.backend.service.IngredientService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ingredients")

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class IngredientController {
    
    @Autowired
    IngredientService ingredientService;

    // Get all ingredients
    @GetMapping
    public ResponseEntity<Iterable<Ingredient>> getAllIngredient() { 
        return ResponseEntity.ok(ingredientService.getAllIngredient());
    }

    // Get ingredient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable("id") int id) { 
        Ingredient ingredient = ingredientService.getIngredientByID(id);
        return ResponseEntity.ok(ingredient);
    }

    // Delete ingredient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable("id") int id) {
        ingredientService.deleteIngredientByID(id);
        return ResponseEntity.noContent().build();
    }

    // Add a new ingredient
    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createdIngredient = ingredientService.createIngredient(ingredient);
        return new ResponseEntity<>(createdIngredient, HttpStatus.CREATED);
    }

    // Update ingredient's amount
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredientAmount(@PathVariable("id") int id, @PathVariable("amount") int amount) {
        Ingredient ingredient = ingredientService.getIngredientByID(id);
        Ingredient updatedIngredient = ingredientService.editIngredientAmt(ingredient, amount);
        return ResponseEntity.ok(updatedIngredient);
    }

    // Get ingredient by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Ingredient> getIngredientByName(@PathVariable String name) {
        return ingredientService.findIngredientByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
