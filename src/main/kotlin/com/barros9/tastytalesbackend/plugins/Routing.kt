package com.barros9.tastytalesbackend.plugins

import com.barros9.tastytalesbackend.model.IngredientDTO
import com.barros9.tastytalesbackend.model.InstructionDTO
import com.barros9.tastytalesbackend.model.RecipeDTO
import com.barros9.tastytalesbackend.model.ReviewDTO
import com.barros9.tastytalesbackend.schema.Ingredients
import com.barros9.tastytalesbackend.schema.Instructions
import com.barros9.tastytalesbackend.schema.Recipes
import com.barros9.tastytalesbackend.schema.Reviews
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {
    routing {
        get("/recipes") {
            try {
                val page = call.request.queryParameters["page"]?.toIntOrNull() ?: 1
                val pageSize = call.request.queryParameters["pageSize"]?.toIntOrNull() ?: 2

                val validPage = page.takeIf { it > 0 } ?: 1
                val validPageSize = pageSize.takeIf { it > 0 } ?: 2

                val recipes = getRecipes(validPage, validPageSize)
                if (recipes.isEmpty()) {
                    call.respond(HttpStatusCode.NoContent, "No recipes found")
                } else {
                    call.respond(recipes)
                }
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, "An unexpected error occurred: $e")
            }
        }

        get("/recipes/{id}") {
            try {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) {
                    call.respond(HttpStatusCode.BadRequest, "Invalid or missing recipe ID")
                    return@get
                }

                val recipe = getRecipeById(id)
                if (recipe != null) {
                    call.respond(recipe)
                } else {
                    call.respond(HttpStatusCode.NotFound, "Recipe not found")
                }
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, "An unexpected error occurred: $e")
            }
        }
    }
}

fun getRecipes(validPage: Int, validPageSize: Int): List<RecipeDTO> = transaction {
    val offset = (validPage - 1) * validPageSize
    Recipes
        .selectAll()
        .limit(validPageSize, offset.toLong())
        .map { recipeRow -> getRecipe(recipeRow) }
}

fun getRecipeById(id: Int): RecipeDTO? = transaction {
    Recipes
        .selectAll()
        .where { Recipes.id eq id }
        .singleOrNull()
        ?.let { recipeRow -> getRecipe(recipeRow) }
}

fun getRecipe(recipeRow: ResultRow): RecipeDTO {
    val recipeId = recipeRow[Recipes.id].value

    return RecipeDTO(
        id = recipeRow[Recipes.id].value,
        name = recipeRow[Recipes.name],
        description = recipeRow[Recipes.description],
        imageUrl = recipeRow[Recipes.imageUrl],
        preparationTime = recipeRow[Recipes.preparationTime],
        cookingTime = recipeRow[Recipes.cookingTime],
        restingTime = recipeRow[Recipes.restingTime],
        servings = recipeRow[Recipes.servings],
        difficulty = recipeRow[Recipes.difficulty],
        tags = recipeRow[Recipes.tags],
        mealType = recipeRow[Recipes.mealType],
        isVegetarian = recipeRow[Recipes.isVegetarian],
        isGlutenFree = recipeRow[Recipes.isGlutenFree],
        isDairyFree = recipeRow[Recipes.isDairyFree],
        isNutFree = recipeRow[Recipes.isNutFree],
        spiceLevel = recipeRow[Recipes.spiceLevel],
        caloriesPerServing = recipeRow[Recipes.caloriesPerServing],
        author = recipeRow[Recipes.author],
        averageRating = recipeRow[Recipes.averageRating],
        createdAt = recipeRow[Recipes.createdAt],
        updatedAt = recipeRow[Recipes.updatedAt],
        ingredients = getIngredientsForRecipe(id = recipeId),
        instructions = getInstructionsForRecipe(id = recipeId),
        reviews = getReviewsForRecipe(id = recipeId)
    )
}

fun getIngredientsForRecipe(id: Int): List<IngredientDTO> = transaction {
    Ingredients
        .selectAll()
        .where { Ingredients.recipeId eq id }
        .map { ingredientRow ->
            IngredientDTO(
                id = ingredientRow[Ingredients.id],
                recipeId = ingredientRow[Ingredients.recipeId],
                name = ingredientRow[Ingredients.name],
                quantity = ingredientRow[Ingredients.quantity],
                unit = ingredientRow[Ingredients.unit]
            )
        }
}

fun getInstructionsForRecipe(id: Int): List<InstructionDTO> = transaction {
    Instructions
        .selectAll()
        .where { Instructions.recipeId eq id }
        .map { instructionRow ->
            InstructionDTO(
                id = instructionRow[Instructions.id],
                recipeId = instructionRow[Instructions.recipeId],
                stepNumber = instructionRow[Instructions.stepNumber],
                description = instructionRow[Instructions.description],
                optionalTip = instructionRow[Instructions.optionalTip]
            )
        }
}

fun getReviewsForRecipe(id: Int): List<ReviewDTO> = transaction {
    Reviews
        .selectAll()
        .where { Reviews.recipeId eq id }
        .map { reviewRow ->
            ReviewDTO(
                id = reviewRow[Reviews.id],
                recipeId = reviewRow[Reviews.recipeId],
                user = reviewRow[Reviews.user],
                rating = reviewRow[Reviews.rating],
                comment = reviewRow[Reviews.comment],
                date = reviewRow[Reviews.date]
            )
        }
}

