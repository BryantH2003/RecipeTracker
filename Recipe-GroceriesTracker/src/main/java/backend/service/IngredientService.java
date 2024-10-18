package backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.model.Ingredient;
import backend.repository.IngredientRepository;

@Service
public class IngredientService {
    @Autowired
    IngredientRepository repository;

    public Ingredient getIngredientByID(int id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Ingredient> getAllIngredient() {
        return repository.findAll();
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public void editIngredientAmt(Ingredient ingredient, int change) {
        ingredient.editIngredientAmt(change);
    }

    public void deleteIngredientByID(int id) {
        repository.deleteById(id);
    }
}
