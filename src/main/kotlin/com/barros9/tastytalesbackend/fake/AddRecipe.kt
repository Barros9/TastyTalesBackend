package com.barros9.tastytalesbackend.fake

import com.barros9.tastytalesbackend.model.DifficultyType
import com.barros9.tastytalesbackend.model.MealType
import com.barros9.tastytalesbackend.model.SpiceLevel
import com.barros9.tastytalesbackend.schema.Ingredients
import com.barros9.tastytalesbackend.schema.Instructions
import com.barros9.tastytalesbackend.schema.Recipes
import com.barros9.tastytalesbackend.schema.Reviews
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

fun addRecipeCarbonara() {
    transaction {
        val recipeId = Recipes.insertAndGetId {
            it[name] = "Spaghetti Carbonara"
            it[description] = "A classic Italian pasta dish made with eggs, cheese, guanciale, and pepper."
            it[imageUrl] = "http://example.com/image.jpg"
            it[preparationTime] = 10
            it[cookingTime] = 15
            it[restingTime] = null
            it[servings] = 4
            it[difficulty] = DifficultyType.MEDIUM.name
            it[tags] = "Italian, Pasta"
            it[mealType] = MealType.DINNER.name
            it[isVegetarian] = false
            it[isGlutenFree] = false
            it[isDairyFree] = false
            it[isNutFree] = true
            it[spiceLevel] = SpiceLevel.MEDIUM.name
            it[caloriesPerServing] = 500
            it[author] = "Chef Mario"
            it[averageRating] = 4.5
            it[createdAt] = LocalDateTime.parse("2024-08-17T15:30:00")
            it[updatedAt] = LocalDateTime.parse("2024-08-17T15:30:00")
        }

        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Spaghetti"
            it[quantity] = "200g"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Eggs"
            it[quantity] = "4"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Guanciale"
            it[quantity] = "100g"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Pecorino Romano"
            it[quantity] = "50g"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Black Pepper"
            it[quantity] = "To taste"
        }

        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 1
            it[description] = "Boil water and cook spaghetti until al dente."
            it[optionalTip] = "Add salt to the boiling water."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 2
            it[description] = "Cook guanciale in a pan until crispy."
            it[optionalTip] = null
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 3
            it[description] = "Mix eggs and Pecorino Romano in a bowl."
            it[optionalTip] = "Add black pepper to the mixture."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 4
            it[description] = "Combine cooked spaghetti with guanciale and remove from heat."
            it[optionalTip] = "Ensure the pan is not too hot when adding the egg mixture."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 5
            it[description] = "Add the egg and cheese mixture to the spaghetti, stirring quickly."
            it[optionalTip] = "Serve immediately with extra Pecorino Romano on top."
        }

        Reviews.insert {
            it[Reviews.recipeId] = recipeId.value
            it[user] = "John Doe"
            it[rating] = 5
            it[comment] = "Delicious recipe! Authentic taste."
            it[date] = LocalDateTime.parse("2024-08-17T15:30:00")
        }
    }
}

fun addRecipeMargheritaPizza() {
    transaction {
        val recipeId = Recipes.insertAndGetId {
            it[name] = "Margherita Pizza"
            it[description] = "A classic Italian pizza with tomato, mozzarella, and basil."
            it[imageUrl] = "http://example.com/pizza.jpg"
            it[preparationTime] = 20
            it[cookingTime] = 15
            it[restingTime] = 60
            it[servings] = 2
            it[difficulty] = DifficultyType.MEDIUM.name
            it[tags] = "Italian, Pizza"
            it[mealType] = MealType.DINNER.name
            it[isVegetarian] = true
            it[isGlutenFree] = false
            it[isDairyFree] = false
            it[isNutFree] = true
            it[spiceLevel] = SpiceLevel.MILD.name
            it[caloriesPerServing] = 800
            it[author] = "Chef Luigi"
            it[averageRating] = 4.7
            it[createdAt] = LocalDateTime.parse("2024-08-18T16:00:00")
            it[updatedAt] = LocalDateTime.parse("2024-08-18T16:00:00")
        }

        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Pizza Dough"
            it[quantity] = "1 batch"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Tomato Sauce"
            it[quantity] = "200g"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Mozzarella Cheese"
            it[quantity] = "150g"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Fresh Basil"
            it[quantity] = "A handful"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Olive Oil"
            it[quantity] = "2 tbsp"
        }

        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 1
            it[description] = "Preheat oven to 250°C (482°F)."
            it[optionalTip] = null
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 2
            it[description] = "Roll out the pizza dough and spread tomato sauce evenly on top."
            it[optionalTip] = "Leave a small border for the crust."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 3
            it[description] = "Add mozzarella cheese and bake in the oven for 10-15 minutes."
            it[optionalTip] = "Bake until the crust is golden and cheese is bubbling."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 4
            it[description] = "Remove from oven and top with fresh basil and a drizzle of olive oil."
            it[optionalTip] = "Serve hot for best flavor."
        }

        Reviews.insert {
            it[Reviews.recipeId] = recipeId.value
            it[user] = "Alice Smith"
            it[rating] = 4
            it[comment] = "Great pizza! Classic and delicious."
            it[date] = LocalDateTime.parse("2024-08-18T16:00:00")
        }
    }
}

fun addRecipeChickenCurry() {
    transaction {
        val recipeId = Recipes.insertAndGetId {
            it[name] = "Chicken Curry"
            it[description] = "A spicy and flavorful chicken curry with a rich sauce."
            it[imageUrl] = "http://example.com/chicken-curry.jpg"
            it[preparationTime] = 15
            it[cookingTime] = 40
            it[restingTime] = null
            it[servings] = 4
            it[difficulty] = DifficultyType.HARD.name
            it[tags] = "Indian, Chicken"
            it[mealType] = MealType.DINNER.name
            it[isVegetarian] = false
            it[isGlutenFree] = false
            it[isDairyFree] = false
            it[isNutFree] = true
            it[spiceLevel] = SpiceLevel.HOT.name
            it[caloriesPerServing] = 600
            it[author] = "Chef Priya"
            it[averageRating] = 4.8
            it[createdAt] = LocalDateTime.parse("2024-08-19T17:00:00")
            it[updatedAt] = LocalDateTime.parse("2024-08-19T17:00:00")
        }

        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Chicken Breast"
            it[quantity] = "500g"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Onion"
            it[quantity] = "1 large"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Tomato"
            it[quantity] = "2 medium"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Coconut Milk"
            it[quantity] = "400ml"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Curry Powder"
            it[quantity] = "3 tbsp"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Garlic"
            it[quantity] = "3 cloves"
        }
        Ingredients.insert {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Ginger"
            it[quantity] = "1 inch piece"
        }

        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 1
            it[description] = "Heat oil in a pan and sauté chopped onions until golden brown."
            it[optionalTip] = null
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 2
            it[description] = "Add minced garlic and ginger, and cook for 2 minutes."
            it[optionalTip] = "Stir frequently to avoid burning."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 3
            it[description] = "Add chopped tomatoes and cook until soft."
            it[optionalTip] = "Use ripe tomatoes for better flavor."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 4
            it[description] = "Add chicken and curry powder, and cook until chicken is browned."
            it[optionalTip] = "Ensure the chicken is fully cooked."
        }
        Instructions.insert {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 5
            it[description] = "Pour in coconut milk, bring to a simmer, and cook for 20 minutes."
            it[optionalTip] = "Adjust seasoning to taste."
        }

        Reviews.insert {
            it[Reviews.recipeId] = recipeId.value
            it[user] = "Michael Johnson"
            it[rating] = 5
            it[comment] = "Excellent curry! Very flavorful and spicy."
            it[date] = LocalDateTime.parse("2024-08-19T17:00:00")
        }
    }
}
