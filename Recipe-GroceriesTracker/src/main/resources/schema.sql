CREATE TABLE IF NOT EXISTS Ingredient (
    ingredientID INT PRIMARY KEY,
    ingredientName VARCHAR(255) NOT NULL,
    ingredientAmt INT NOT NULL,
    previousRestockDate DATE NOT NULL DEFAULT CURRENT_DATE,
    restockDate DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS Recipe (
    recipeID INT PRIMARY KEY,
    recipeName VARCHAR(255) DEFAULT "",
    dateAdded DATE NOT NULL DEFAULT CURRENT_DATE,
    recipeImage VARCHAR(255) DEFAULT "",
    recipeInstructions VARCHAR(255) DEFAULT "",
    recipeVideo VARCHAR(255) DEFAULT "",
    servingSize VARCHAR(255) DEFAULT "",
    rating INT DEFAULT 0
)