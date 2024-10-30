package com.recipetracker.Recipe.GroceriesTracker.backend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.recipetracker.Recipe.GroceriesTracker.backend.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository <Recipe, Integer>{
    // Find Recipe by Name
    Optional<Recipe> findByRecipeName(String name);

    // Order Recipes by Rating in Descending Order
    List<Recipe> findAllByOrderByRatingDesc();

    // Order Recipes by Rating in Ascending Order
    List<Recipe> findAllByOrderByRatingAsc();

    // Find list of recipe with a specfic rating
    List<Recipe> findRecipeByRating(int rating);
}
