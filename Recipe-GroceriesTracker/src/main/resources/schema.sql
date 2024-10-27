CREATE TABLE IF NOT EXISTS Ingredient (
    ingredientID INT PRIMARY KEY,
    ingredientName VARCHAR(255) NOT NULL,
    ingredientAmt INT NOT NULL,
    previousRestockDate DATE NOT NULL DEFAULT CURRENT_DATE,
    restockDate DATE NOT NULL DEFAULT CURRENT_DATE
);