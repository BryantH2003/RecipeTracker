package com.recipetracker.Recipe.GroceriesTracker.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Column(nullable = false)
    private Date previousRestockDate;

    @Column(nullable = false)
    private Date restockDate;

    // Initialize the date fields in the constructor
    public Ingredient(String ingredientName, int ingredientAmt) {
        this.ingredientName = ingredientName;
        this.ingredientAmt = ingredientAmt;
        this.previousRestockDate = Date.valueOf(LocalDate.now());
        this.restockDate = Date.valueOf(LocalDate.now());
    }

    // Custom setter logic for the amount, if necessary
    public void editIngredientAmt(int amount) {
        this.ingredientAmt += amount;
    }
}
