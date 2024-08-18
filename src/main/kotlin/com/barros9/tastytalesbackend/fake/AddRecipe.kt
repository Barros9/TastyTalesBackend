package com.barros9.tastytalesbackend.fake

import com.barros9.tastytalesbackend.model.DifficultyType
import com.barros9.tastytalesbackend.model.MealType
import com.barros9.tastytalesbackend.model.SpiceLevel
import com.barros9.tastytalesbackend.schema.*
import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

fun addRecipeCarbonara() {
    transaction {
        // region Recipes
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

        // region RecipesTranslations
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "en"
            it[name] = "Spaghetti Carbonara"
            it[description] = "A classic Italian pasta dish made with eggs, cheese, guanciale, and pepper."
            it[tags] = "Italian, Pasta"
        }
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "es"
            it[name] = "Espaguetis a la Carbonara"
            it[description] = "Un clásico plato de pasta italiano hecho con huevos, queso, guanciale y pimienta."
            it[tags] = "Italiano, Pasta"
        }
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "it"
            it[name] = "Spaghetti alla Carbonara"
            it[description] = "Un classico piatto di pasta italiano fatto con uova, formaggio, guanciale e pepe."
            it[tags] = "Italiano, Pasta"
        }
        // endregion

        // region Ingredients
        val spaghettiId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Spaghetti"
            it[quantity] = "200g"
        }
        val eggsId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Eggs"
            it[quantity] = "4"
        }
        val guancialeId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Guanciale"
            it[quantity] = "100g"
        }
        val pecorinoId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Pecorino Romano"
            it[quantity] = "50g"
        }
        val blackPepperId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Black Pepper"
            it[quantity] = "To taste"
        }

        // region IngredientsTranslations
        IngredientsTranslations.insert {
            it[ingredientId] = spaghettiId.value
            it[language] = "en"
            it[name] = "Spaghetti"
            it[quantity] = "200g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = eggsId.value
            it[language] = "en"
            it[name] = "Eggs"
            it[quantity] = "4"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = guancialeId.value
            it[language] = "en"
            it[name] = "Guanciale"
            it[quantity] = "100g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = pecorinoId.value
            it[language] = "en"
            it[name] = "Pecorino Romano"
            it[quantity] = "50g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = blackPepperId.value
            it[language] = "en"
            it[name] = "Black Pepper"
            it[quantity] = "To taste"
            it[unit] = null
        }

        IngredientsTranslations.insert {
            it[ingredientId] = spaghettiId.value
            it[language] = "es"
            it[name] = "Espaguetis"
            it[quantity] = "200g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = eggsId.value
            it[language] = "es"
            it[name] = "Huevos"
            it[quantity] = "4"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = guancialeId.value
            it[language] = "es"
            it[name] = "Guanciale"
            it[quantity] = "100g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = pecorinoId.value
            it[language] = "es"
            it[name] = "Pecorino Romano"
            it[quantity] = "50g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = blackPepperId.value
            it[language] = "es"
            it[name] = "Pimienta Negra"
            it[quantity] = "Al gusto"
            it[unit] = null
        }

        IngredientsTranslations.insert {
            it[ingredientId] = spaghettiId.value
            it[language] = "it"
            it[name] = "Spaghetti"
            it[quantity] = "200g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = eggsId.value
            it[language] = "it"
            it[name] = "Uova"
            it[quantity] = "4"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = guancialeId.value
            it[language] = "it"
            it[name] = "Guanciale"
            it[quantity] = "100g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = pecorinoId.value
            it[language] = "it"
            it[name] = "Pecorino Romano"
            it[quantity] = "50g"
            it[unit] = null
        }
        IngredientsTranslations.insert {
            it[ingredientId] = blackPepperId.value
            it[language] = "it"
            it[name] = "Pepe Nero"
            it[quantity] = "A piacere"
            it[unit] = null
        }
        // endregion

        // endregion

        // region Instructions
        val step1Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 1
            it[description] = "Boil water and cook spaghetti until al dente."
            it[optionalTip] = "Add salt to the boiling water."
        }

        val step2Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 2
            it[description] = "Cook guanciale in a pan until crispy."
            it[optionalTip] = null
        }

        val step3Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 3
            it[description] = "Mix eggs and Pecorino Romano in a bowl."
            it[optionalTip] = "Add black pepper to the mixture."
        }

        val step4Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 4
            it[description] = "Combine cooked spaghetti with guanciale and remove from heat."
            it[optionalTip] = "Ensure the pan is not too hot when adding the egg mixture."
        }

        val step5Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 5
            it[description] = "Add the egg and cheese mixture to the spaghetti, stirring quickly."
            it[optionalTip] = "Serve immediately with extra Pecorino Romano on top."
        }

        // region InstructionsTranslations
        InstructionsTranslations.insert {
            it[instructionId] = step1Id.value
            it[language] = "en"
            it[description] = "Boil water and cook spaghetti until al dente."
            it[optionalTip] = "Add salt to the boiling water."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step2Id.value
            it[language] = "en"
            it[description] = "Cook guanciale in a pan until crispy."
            it[optionalTip] = null
        }

        InstructionsTranslations.insert {
            it[instructionId] = step3Id.value
            it[language] = "en"
            it[description] = "Mix eggs and Pecorino Romano in a bowl."
            it[optionalTip] = "Add black pepper to the mixture."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step4Id.value
            it[language] = "en"
            it[description] = "Combine cooked spaghetti with guanciale and remove from heat."
            it[optionalTip] = "Ensure the pan is not too hot when adding the egg mixture."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step5Id.value
            it[language] = "en"
            it[description] = "Add the egg and cheese mixture to the spaghetti, stirring quickly."
            it[optionalTip] = "Serve immediately with extra Pecorino Romano on top."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step1Id.value
            it[language] = "es"
            it[description] = "Hervir agua y cocinar los espaguetis hasta que estén al dente."
            it[optionalTip] = "Añadir sal al agua hirviendo."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step2Id.value
            it[language] = "es"
            it[description] = "Cocinar guanciale en una sartén hasta que esté crujiente."
            it[optionalTip] = null
        }

        InstructionsTranslations.insert {
            it[instructionId] = step3Id.value
            it[language] = "es"
            it[description] = "Mezclar huevos y Pecorino Romano en un bol."
            it[optionalTip] = "Añadir pimienta negra a la mezcla."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step4Id.value
            it[language] = "es"
            it[description] = "Combinar los espaguetis cocidos con guanciale y retirar del fuego."
            it[optionalTip] = "Asegúrate de que la sartén no esté demasiado caliente al añadir la mezcla de huevos."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step5Id.value
            it[language] = "es"
            it[description] = "Añadir la mezcla de huevo y queso a los espaguetis, removiendo rápidamente."
            it[optionalTip] = "Servir inmediatamente con extra Pecorino Romano por encima."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step1Id.value
            it[language] = "it"
            it[description] = "Porta a ebollizione l'acqua e cuoci gli spaghetti fino a che non siano al dente."
            it[optionalTip] = "Aggiungi sale all'acqua bollente."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step2Id.value
            it[language] = "it"
            it[description] = "Cuoci il guanciale in una padella fino a renderlo croccante."
            it[optionalTip] = null
        }

        InstructionsTranslations.insert {
            it[instructionId] = step3Id.value
            it[language] = "it"
            it[description] = "Mescola le uova e il Pecorino Romano in una ciotola."
            it[optionalTip] = "Aggiungi pepe nero alla miscela."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step4Id.value
            it[language] = "it"
            it[description] = "Unisci gli spaghetti cotti con il guanciale e togli dal fuoco."
            it[optionalTip] = "Assicurati che la padella non sia troppo calda quando aggiungi la miscela di uova."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step5Id.value
            it[language] = "it"
            it[description] = "Aggiungi la miscela di uova e formaggio agli spaghetti, mescolando rapidamente."
            it[optionalTip] = "Servi immediatamente con extra Pecorino Romano sopra."
        }
        // endregion

        // endregion

        // region Reviews
        val review1Id = Reviews.insertAndGetId {
            it[Reviews.recipeId] = recipeId.value
            it[user] = "John Doe"
            it[rating] = 5
            it[comment] = "Delicious recipe! Authentic taste."
            it[date] = LocalDateTime.parse("2024-08-17T15:30:00")
        }

        // region ReviewsTranslations
        ReviewsTranslations.insert {
            it[reviewId] = review1Id.value
            it[language] = "en"
            it[comment] = "Delicious recipe! Authentic taste."
        }

        ReviewsTranslations.insert {
            it[reviewId] = review1Id.value
            it[language] = "es"
            it[comment] = "¡Receta deliciosa! Sabor auténtico."
        }

        ReviewsTranslations.insert {
            it[reviewId] = review1Id.value
            it[language] = "it"
            it[comment] = "Ricetta deliziosa! Sapore autentico."
        }
        // endregion

        // endregion
    }
}

fun addRecipeMargheritaPizza() {
    transaction {
        // region Recipes
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

        // region RecipesTranslations
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "en"
            it[name] = "Margherita Pizza"
            it[description] = "A classic Italian pizza with tomato, mozzarella, and basil."
            it[tags] = "Italian, Pizza"
        }
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "es"
            it[name] = "Pizza Margherita"
            it[description] = "Una clásica pizza italiana con tomate, mozzarella y albahaca."
            it[tags] = "Italiano, Pizza"
        }
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "it"
            it[name] = "Pizza Margherita"
            it[description] = "Una classica pizza italiana con pomodoro, mozzarella e basilico."
            it[tags] = "Italiano, Pizza"
        }
        // endregion

        // region Ingredients
        val pizzaDoughId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Pizza Dough"
            it[quantity] = "1 batch"
        }.value

        val tomatoSauceId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Tomato Sauce"
            it[quantity] = "200g"
        }.value

        val mozzarellaCheeseId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Mozzarella Cheese"
            it[quantity] = "150g"
        }.value

        val freshBasilId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Fresh Basil"
            it[quantity] = "A handful"
        }.value

        val oliveOilId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Olive Oil"
            it[quantity] = "2 tbsp"
        }.value

        // region IngredientsTranslations
        IngredientsTranslations.insert {
            it[ingredientId] = pizzaDoughId
            it[language] = "en"
            it[name] = "Pizza Dough"
            it[quantity] = "1 batch"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = tomatoSauceId
            it[language] = "en"
            it[name] = "Tomato Sauce"
            it[quantity] = "200g"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = mozzarellaCheeseId
            it[language] = "en"
            it[name] = "Mozzarella Cheese"
            it[quantity] = "150g"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = freshBasilId
            it[language] = "en"
            it[name] = "Fresh Basil"
            it[quantity] = "A handful"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = oliveOilId
            it[language] = "en"
            it[name] = "Olive Oil"
            it[quantity] = "2 tbsp"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = pizzaDoughId
            it[language] = "es"
            it[name] = "Masa para Pizza"
            it[quantity] = "1 lote"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = tomatoSauceId
            it[language] = "es"
            it[name] = "Salsa de Tomate"
            it[quantity] = "200g"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = mozzarellaCheeseId
            it[language] = "es"
            it[name] = "Queso Mozzarella"
            it[quantity] = "150g"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = freshBasilId
            it[language] = "es"
            it[name] = "Albahaca Fresca"
            it[quantity] = "Un puñado"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = oliveOilId
            it[language] = "es"
            it[name] = "Aceite de Oliva"
            it[quantity] = "2 cucharadas"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = pizzaDoughId
            it[language] = "it"
            it[name] = "Impasto per Pizza"
            it[quantity] = "1 porzione"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = tomatoSauceId
            it[language] = "it"
            it[name] = "Salsa di Pomodoro"
            it[quantity] = "200g"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = mozzarellaCheeseId
            it[language] = "it"
            it[name] = "Mozzarella"
            it[quantity] = "150g"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = freshBasilId
            it[language] = "it"
            it[name] = "Basilico Fresco"
            it[quantity] = "Un pugno"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = oliveOilId
            it[language] = "it"
            it[name] = "Olio d'Oliva"
            it[quantity] = "2 cucchiai"
        }
        // endregion

        // endregion

        // region Instructions
        val step1Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 1
            it[description] = "Preheat oven to 250°C (482°F)."
            it[optionalTip] = null
        }.value

        val step2Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 2
            it[description] = "Roll out the pizza dough and spread tomato sauce evenly on top."
            it[optionalTip] = "Leave a small border for the crust."
        }.value

        val step3Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 3
            it[description] = "Add mozzarella cheese and bake in the oven for 10-15 minutes."
            it[optionalTip] = "Bake until the crust is golden and cheese is bubbling."
        }.value

        val step4Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 4
            it[description] = "Remove from oven and top with fresh basil and a drizzle of olive oil."
            it[optionalTip] = "Serve hot for best flavor."
        }.value

        // region InstructionsTranslations
        InstructionsTranslations.insert {
            it[instructionId] = step1Id
            it[language] = "en"
            it[description] = "Preheat oven to 250°C (482°F)."
            it[optionalTip] = null
        }

        InstructionsTranslations.insert {
            it[instructionId] = step2Id
            it[language] = "en"
            it[description] = "Roll out the pizza dough and spread tomato sauce evenly on top."
            it[optionalTip] = "Leave a small border for the crust."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step3Id
            it[language] = "en"
            it[description] = "Add mozzarella cheese and bake in the oven for 10-15 minutes."
            it[optionalTip] = "Bake until the crust is golden and cheese is bubbling."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step4Id
            it[language] = "en"
            it[description] = "Remove from oven and top with fresh basil and a drizzle of olive oil."
            it[optionalTip] = "Serve hot for best flavor."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step1Id
            it[language] = "es"
            it[description] = "Precalienta el horno a 250°C (482°F)."
            it[optionalTip] = null
        }

        InstructionsTranslations.insert {
            it[instructionId] = step2Id
            it[language] = "es"
            it[description] = "Extiende la masa para pizza y esparce la salsa de tomate uniformemente por encima."
            it[optionalTip] = "Deja un pequeño borde para la corteza."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step3Id
            it[language] = "es"
            it[description] = "Añade queso mozzarella y hornea en el horno durante 10-15 minutos."
            it[optionalTip] = "Hornea hasta que la corteza esté dorada y el queso burbujeante."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step4Id
            it[language] = "es"
            it[description] = "Saca del horno y agrega albahaca fresca y un chorrito de aceite de oliva."
            it[optionalTip] = "Sirve caliente para el mejor sabor."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step1Id
            it[language] = "it"
            it[description] = "Preriscalda il forno a 250°C (482°F)."
            it[optionalTip] = null
        }

        InstructionsTranslations.insert {
            it[instructionId] = step2Id
            it[language] = "it"
            it[description] = "Stendi l'impasto per pizza e distribuisci uniformemente la salsa di pomodoro sopra."
            it[optionalTip] = "Lascia un piccolo bordo per la crosta."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step3Id
            it[language] = "it"
            it[description] = "Aggiungi la mozzarella e inforna per 10-15 minuti."
            it[optionalTip] = "Cuoci fino a quando la crosta è dorata e il formaggio è spumeggiante."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step4Id
            it[language] = "it"
            it[description] = "Togli dal forno e completa con basilico fresco e un filo d'olio d'oliva."
            it[optionalTip] = "Servi caldo per il miglior sapore."
        }
        // endregion

        // endregion

        // region Reviews
        val review1Id = Reviews.insertAndGetId {
            it[Reviews.recipeId] = recipeId.value
            it[user] = "Alice Smith"
            it[rating] = 4
            it[comment] = "Great pizza! Classic and delicious."
            it[date] = LocalDateTime.parse("2024-08-18T16:00:00")
        }.value

        // region ReviewsTranslations
        ReviewsTranslations.insert {
            it[reviewId] = review1Id
            it[language] = "en"
            it[comment] = "Great pizza! Classic and delicious."
        }

        ReviewsTranslations.insert {
            it[reviewId] = review1Id
            it[language] = "es"
            it[comment] = "¡Gran pizza! Clásica y deliciosa."
        }

        ReviewsTranslations.insert {
            it[reviewId] = review1Id
            it[language] = "it"
            it[comment] = "Ottima pizza! Classica e deliziosa."
        }
        // endregion

        // endregion
    }
}

fun addRecipeChickenCurry() {
    transaction {
        // region Recipes
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

        // region RecipesTranslations
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "en"
            it[name] = "Chicken Curry"
            it[description] = "A spicy and flavorful chicken curry with a rich sauce."
            it[tags] = "Indian, Chicken"
        }
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "es"
            it[name] = "Curry de Pollo"
            it[description] = "Un curry de pollo picante y sabroso con una salsa rica."
            it[tags] = "Indio, Pollo"
        }
        RecipesTranslations.insert {
            it[RecipesTranslations.recipeId] = recipeId.value
            it[language] = "it"
            it[name] = "Curry di Pollo"
            it[description] = "Un curry di pollo piccante e saporito con una salsa ricca."
            it[tags] = "Indiano, Pollo"
        }
        // endregion

        // region Ingredients
        val chickenBreastId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Chicken Breast"
            it[quantity] = "500g"
        }.value

        val onionId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Onion"
            it[quantity] = "1 large"
        }.value

        val tomatoId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Tomato"
            it[quantity] = "2 medium"
        }.value

        val coconutMilkId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Coconut Milk"
            it[quantity] = "400ml"
        }.value

        val curryPowderId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Curry Powder"
            it[quantity] = "3 tbsp"
        }.value

        val garlicId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Garlic"
            it[quantity] = "3 cloves"
        }.value

        val gingerId = Ingredients.insertAndGetId {
            it[Ingredients.recipeId] = recipeId.value
            it[name] = "Ginger"
            it[quantity] = "1 inch piece"
        }.value

        // region IngredientsTranslations
        IngredientsTranslations.insert {
            it[ingredientId] = chickenBreastId
            it[language] = "en"
            it[name] = "Chicken Breast"
            it[quantity] = "500g"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = onionId
            it[language] = "en"
            it[name] = "Onion"
            it[quantity] = "1 large"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = tomatoId
            it[language] = "en"
            it[name] = "Tomato"
            it[quantity] = "2 medium"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = coconutMilkId
            it[language] = "en"
            it[name] = "Coconut Milk"
            it[quantity] = "400ml"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = curryPowderId
            it[language] = "en"
            it[name] = "Curry Powder"
            it[quantity] = "3 tbsp"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = garlicId
            it[language] = "en"
            it[name] = "Garlic"
            it[quantity] = "3 cloves"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = gingerId
            it[language] = "en"
            it[name] = "Ginger"
            it[quantity] = "1 inch piece"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = chickenBreastId
            it[language] = "es"
            it[name] = "Pechuga de Pollo"
            it[quantity] = "500g"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = onionId
            it[language] = "es"
            it[name] = "Cebolla"
            it[quantity] = "1 grande"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = tomatoId
            it[language] = "es"
            it[name] = "Tomate"
            it[quantity] = "2 medianos"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = coconutMilkId
            it[language] = "es"
            it[name] = "Leche de Coco"
            it[quantity] = "400ml"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = curryPowderId
            it[language] = "es"
            it[name] = "Polvo de Curry"
            it[quantity] = "3 cucharadas"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = garlicId
            it[language] = "es"
            it[name] = "Ajo"
            it[quantity] = "3 dientes"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = gingerId
            it[language] = "es"
            it[name] = "Jengibre"
            it[quantity] = "1 trozo de 1 pulgada"
        }

        IngredientsTranslations.insert {
            it[ingredientId] = chickenBreastId
            it[language] = "it"
            it[name] = "Petto di Pollo"
            it[quantity] = "500g"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = onionId
            it[language] = "it"
            it[name] = "Cipolla"
            it[quantity] = "1 grande"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = tomatoId
            it[language] = "it"
            it[name] = "Pomodoro"
            it[quantity] = "2 medi"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = coconutMilkId
            it[language] = "it"
            it[name] = "Latte di Cocco"
            it[quantity] = "400ml"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = curryPowderId
            it[language] = "it"
            it[name] = "Polvere di Curry"
            it[quantity] = "3 cucchiai"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = garlicId
            it[language] = "it"
            it[name] = "Aglio"
            it[quantity] = "3 spicchi"
        }
        IngredientsTranslations.insert {
            it[ingredientId] = gingerId
            it[language] = "it"
            it[name] = "Zenzero"
            it[quantity] = "1 pezzo di 2,5 cm"
        }
        // endregion

        // endregion

        // region Instructions
        val step1Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 1
            it[description] = "Heat oil in a pan and sauté chopped onions until golden brown."
            it[optionalTip] = null
        }.value

        val step2Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 2
            it[description] = "Add minced garlic and ginger, and cook for 2 minutes."
            it[optionalTip] = "Stir frequently to avoid burning."
        }.value

        val step3Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 3
            it[description] = "Add chopped tomatoes and cook until soft."
            it[optionalTip] = "Use ripe tomatoes for better flavor."
        }.value

        val step4Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 4
            it[description] = "Add chicken and curry powder, and cook until chicken is browned."
            it[optionalTip] = "Ensure the chicken is fully cooked."
        }.value

        val step5Id = Instructions.insertAndGetId {
            it[Instructions.recipeId] = recipeId.value
            it[stepNumber] = 5
            it[description] = "Pour in coconut milk, bring to a simmer, and cook for 20 minutes."
            it[optionalTip] = "Adjust seasoning to taste."
        }.value

        // region InstructionsTranslations
        InstructionsTranslations.insert {
            it[instructionId] = step1Id
            it[language] = "en"
            it[description] = "Heat oil in a pan and sauté chopped onions until golden brown."
            it[optionalTip] = null
        }
        InstructionsTranslations.insert {
            it[instructionId] = step2Id
            it[language] = "en"
            it[description] = "Add minced garlic and ginger, and cook for 2 minutes."
            it[optionalTip] = "Stir frequently to avoid burning."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step3Id
            it[language] = "en"
            it[description] = "Add chopped tomatoes and cook until soft."
            it[optionalTip] = "Use ripe tomatoes for better flavor."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step4Id
            it[language] = "en"
            it[description] = "Add chicken and curry powder, and cook until chicken is browned."
            it[optionalTip] = "Ensure the chicken is fully cooked."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step5Id
            it[language] = "en"
            it[description] = "Pour in coconut milk, bring to a simmer, and cook for 20 minutes."
            it[optionalTip] = "Adjust seasoning to taste."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step1Id
            it[language] = "es"
            it[description] = "Calienta el aceite en una sartén y sofríe las cebollas picadas hasta que estén doradas."
            it[optionalTip] = null
        }
        InstructionsTranslations.insert {
            it[instructionId] = step2Id
            it[language] = "es"
            it[description] = "Añade ajo y jengibre picados y cocina durante 2 minutos."
            it[optionalTip] = "Revuelve con frecuencia para evitar que se queme."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step3Id
            it[language] = "es"
            it[description] = "Añade tomates picados y cocina hasta que estén tiernos."
            it[optionalTip] = "Usa tomates maduros para un mejor sabor."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step4Id
            it[language] = "es"
            it[description] = "Añade el pollo y el polvo de curry, y cocina hasta que el pollo esté dorado."
            it[optionalTip] = "Asegúrate de que el pollo esté completamente cocido."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step5Id
            it[language] = "es"
            it[description] = "Añade la leche de coco, lleva a ebullición y cocina durante 20 minutos."
            it[optionalTip] = "Ajusta el condimento al gusto."
        }

        InstructionsTranslations.insert {
            it[instructionId] = step1Id
            it[language] = "it"
            it[description] = "Scalda l'olio in una padella e soffriggi le cipolle tritate fino a doratura."
            it[optionalTip] = null
        }
        InstructionsTranslations.insert {
            it[instructionId] = step2Id
            it[language] = "it"
            it[description] = "Aggiungi l'aglio e lo zenzero tritati e cuoci per 2 minuti."
            it[optionalTip] = "Mescola frequentemente per evitare che si bruci."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step3Id
            it[language] = "it"
            it[description] = "Aggiungi i pomodori tritati e cuoci fino a quando sono morbidi."
            it[optionalTip] = "Usa pomodori maturi per un sapore migliore."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step4Id
            it[language] = "it"
            it[description] = "Aggiungi il pollo e la polvere di curry e cuoci fino a quando il pollo è dorato."
            it[optionalTip] = "Assicurati che il pollo sia completamente cotto."
        }
        InstructionsTranslations.insert {
            it[instructionId] = step5Id
            it[language] = "it"
            it[description] = "Versa il latte di cocco, porta a ebollizione e cuoci per 20 minuti."
            it[optionalTip] = "Regola il condimento a piacere."
        }
        // endregion

        // endregion

        // region Reviews
        val review1Id = Reviews.insertAndGetId {
            it[Reviews.recipeId] = recipeId.value
            it[user] = "Michael Johnson"
            it[rating] = 5
            it[comment] = "Excellent curry! Very flavorful and spicy."
            it[date] = LocalDateTime.parse("2024-08-19T17:00:00")
        }.value

        // region ReviewsTranslations
        ReviewsTranslations.insert {
            it[reviewId] = review1Id
            it[language] = "en"
            it[comment] = "Excellent curry! Very flavorful and spicy."
        }

        ReviewsTranslations.insert {
            it[reviewId] = review1Id
            it[language] = "es"
            it[comment] = "¡Curry excelente! Muy sabroso y picante."
        }

        ReviewsTranslations.insert {
            it[reviewId] = review1Id
            it[language] = "it"
            it[comment] = "Curry eccellente! Molto saporito e piccante."
        }
        // endregion

        // endregion
    }
}

