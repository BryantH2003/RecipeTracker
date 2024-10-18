package backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import backend.service.IngredientService;
import backend.model.Ingredient;

public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping("/ingredients")
    public Iterable<Ingredient> getAllIngredient() { 
        return ingredientService.getAllIngredient();
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredient(@PathVariable("id") int id) { 
        return ingredientService.getIngredientByID(id);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        ingredientService.deleteIngredientByID(id);
     }

    @PostMapping("/ingredients")
    public void addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.createIngredient(ingredient);
    }

    @PutMapping("/ingredients")
    public void updateIngredient(@RequestBody Ingredient ingredient, int amount) {
        ingredientService.editIngredientAmt(ingredient, amount);
    }
}
