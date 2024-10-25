package com.recipetracker.Recipe.GroceriesTracker.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "ingredientName")
})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientID;

    @NotBlank(message = "Ingredient name is mandatory")
    private String ingredientName;

    @Min(value = 0, message = "Ingredient amount should not be less than 0")
    private int ingredientAmt;

    // Custom setter logic for the amount, if necessary
    public void editIngredientAmt(int amount) {
        this.ingredientAmt += amount;
    }
}
