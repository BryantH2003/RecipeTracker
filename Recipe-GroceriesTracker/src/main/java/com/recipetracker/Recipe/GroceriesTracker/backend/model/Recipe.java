package com.recipetracker.Recipe.GroceriesTracker.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "recipeName")
})

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeID;

    @NotBlank(message = "Recipe name is mandatory")
    private String recipeName;

    @Column(nullable = false)
    private Date dateAdded;

    private String recipeImage;

    private String recipeInstructions;

    private String recipeVideo;

    private int servingSize;

    private int rating;

    public Recipe (String recipeName, String recipeImage, String recipeInstructions, String recipeVideo, int servingSize, int recipeRating) {
        this.recipeName = recipeName;
        this.dateAdded = Date.valueOf(LocalDate.now());
        this.recipeImage = recipeImage;
        this.recipeInstructions = recipeInstructions;
        this.recipeVideo = recipeVideo;
        this.servingSize = servingSize;
        this.rating = recipeRating;
    }

    public void setRating (int rating) {
        this.rating = rating;
    }

    public int getRating () {
        return this.rating;
    }
}
