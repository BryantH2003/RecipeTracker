package backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Ingredient {
    @Id
    @Column
    private int ingredientID;
    
    @Column
    private int ingredientAmt;

    @Column
    private String ingredientName;

    public int getIngredientID() { return ingredientID; }

    public String getIngredientName() { return ingredientName; }

    public int getIngredientAmt() { return ingredientAmt; }

    public void setIngredientAmt(int amount) { this.ingredientAmt = amount; }

    public void editIngredientAmt(int amount) { this.ingredientAmt += amount; }

    public void setIngredientName(String name) { this.ingredientName = name; }
}
