package com.barros9.tastytalesbackend.plugins

import com.barros9.tastytalesbackend.model.*
import com.barros9.tastytalesbackend.schema.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
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

                val language = call.request.headers["Accept-Language"] ?: "en"

                val recipes = getRecipes(validPage, validPageSize, language)
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

                val language = call.request.headers["Accept-Language"] ?: "en"

                val recipe = getRecipeById(id, language)
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

fun getRecipes(validPage: Int, validPageSize: Int, language: String): List<RecipeDTO> = transaction {
    val offset = (validPage - 1) * validPageSize

    val recipesRows = Recipes
        .selectAll()
        .limit(validPageSize, offset.toLong())
        .toList()

    val recipeIds = recipesRows.map { it[Recipes.id].value }
    val recipesTranslations = RecipesTranslations
        .selectAll()
        .where { RecipesTranslations.recipeId inList recipeIds }
        .groupBy { it[RecipesTranslations.recipeId] }

    recipesRows.map { recipeRow ->
        val recipeId = recipeRow[Recipes.id].value
        val translationRow =
            recipesTranslations[recipeId]?.singleOrNull { it[RecipesTranslations.language] == language }
        mapRecipe(recipeRow, translationRow, language)
    }
}

fun getRecipeById(id: Int, language: String): RecipeDTO? = transaction {
    val recipeRow = Recipes
        .selectAll()
        .where { Recipes.id eq id }
        .singleOrNull()
        ?: return@transaction null

    val recipesTranslations = RecipesTranslations
        .selectAll()
        .where {
            (RecipesTranslations.recipeId eq id) and (RecipesTranslations.language eq language)
        }
        .singleOrNull()

    mapRecipe(recipeRow, recipesTranslations, language)
}

fun mapRecipe(recipeRow: ResultRow, translationRows: ResultRow?, language: String): RecipeDTO {
    val recipeId = recipeRow[Recipes.id].value

    return RecipeDTO(
        id = recipeRow[Recipes.id].value,
        name = translationRows?.get(RecipesTranslations.name) ?: recipeRow[Recipes.id].value.toString(),
        description = translationRows?.get(RecipesTranslations.description) ?: recipeRow[Recipes.description],
        imageUrl = recipeRow[Recipes.imageUrl],
        preparationTime = recipeRow[Recipes.preparationTime],
        cookingTime = recipeRow[Recipes.cookingTime],
        restingTime = recipeRow[Recipes.restingTime],
        servings = recipeRow[Recipes.servings],
        difficulty = DifficultyType.valueOf(recipeRow[Recipes.difficulty]),
        tags = translationRows?.get(RecipesTranslations.tags) ?: recipeRow[Recipes.tags],
        mealType = MealType.valueOf(recipeRow[Recipes.mealType]),
        isVegetarian = recipeRow[Recipes.isVegetarian],
        isGlutenFree = recipeRow[Recipes.isGlutenFree],
        isDairyFree = recipeRow[Recipes.isDairyFree],
        isNutFree = recipeRow[Recipes.isNutFree],
        spiceLevel = SpiceLevel.valueOf(recipeRow[Recipes.spiceLevel]),
        caloriesPerServing = recipeRow[Recipes.caloriesPerServing],
        author = recipeRow[Recipes.author],
        averageRating = recipeRow[Recipes.averageRating],
        createdAt = recipeRow[Recipes.createdAt],
        updatedAt = recipeRow[Recipes.updatedAt],
        ingredients = getIngredientsForRecipe(recipeId = recipeId, language = language),
        instructions = getInstructionsForRecipe(recipeId = recipeId, language = language),
        reviews = getReviewsForRecipe(recipeId = recipeId, language = language)
    )
}

fun getIngredientsForRecipe(recipeId: Int, language: String): List<IngredientDTO> = transaction {
    val ingredients = Ingredients
        .selectAll()
        .where { Ingredients.recipeId eq recipeId }
        .toList()

    val ingredientTranslations = IngredientsTranslations
        .selectAll()
        .where { IngredientsTranslations.language eq language }
        .toList()
        .associateBy { it[IngredientsTranslations.ingredientId] }

    ingredients.map { ingredientRow ->
        val ingredientId = ingredientRow[Ingredients.id].value
        val translationRow = ingredientTranslations[ingredientId]

        mapIngredient(ingredientRow, translationRow)
    }
}

fun mapIngredient(ingredientRow: ResultRow, translationRow: ResultRow?): IngredientDTO =
    IngredientDTO(
        id = ingredientRow[Ingredients.id].value,
        recipeId = ingredientRow[Ingredients.recipeId],
        name = translationRow?.get(IngredientsTranslations.name) ?: ingredientRow[Ingredients.name],
        quantity = translationRow?.get(IngredientsTranslations.quantity) ?: ingredientRow[Ingredients.quantity],
        unit = translationRow?.get(IngredientsTranslations.unit) ?: ingredientRow[Ingredients.unit]
    )

fun getInstructionsForRecipe(recipeId: Int, language: String): List<InstructionDTO> = transaction {
    val instructions = Instructions
        .selectAll()
        .where { Instructions.recipeId eq recipeId }
        .toList()

    val instructionsTranslations = InstructionsTranslations
        .selectAll()
        .where { InstructionsTranslations.language eq language }
        .toList()
        .associateBy { it[InstructionsTranslations.instructionId] }

    instructions.map { instructionsRow ->
        val instructionsId = instructionsRow[Instructions.id].value
        val translationRow = instructionsTranslations[instructionsId]

        mapInstruction(instructionsRow, translationRow)
    }
}

fun mapInstruction(instructionRow: ResultRow, translationRow: ResultRow?): InstructionDTO =
    InstructionDTO(
        id = instructionRow[Instructions.id].value,
        recipeId = instructionRow[Instructions.recipeId],
        stepNumber = instructionRow[Instructions.stepNumber],
        description = translationRow?.get(InstructionsTranslations.description)
            ?: instructionRow[Instructions.description],
        optionalTip = translationRow?.get(InstructionsTranslations.optionalTip)
            ?: instructionRow[Instructions.optionalTip]
    )

fun getReviewsForRecipe(recipeId: Int, language: String): List<ReviewDTO> = transaction {
    val reviews = Reviews
        .selectAll()
        .where { Reviews.recipeId eq recipeId }
        .toList()

    val reviewsTranslations = ReviewsTranslations
        .selectAll()
        .where { ReviewsTranslations.language eq language }
        .toList()
        .associateBy { it[ReviewsTranslations.reviewId] }

    reviews.map { reviewsRow ->
        val reviewsId = reviewsRow[Reviews.id].value
        val translationRow = reviewsTranslations[reviewsId]

        mapReview(reviewsRow, translationRow)
    }
}

fun mapReview(reviewRow: ResultRow, translationRow: ResultRow?): ReviewDTO =
    ReviewDTO(
        id = reviewRow[Reviews.id].value,
        recipeId = reviewRow[Reviews.recipeId],
        user = reviewRow[Reviews.user],
        rating = reviewRow[Reviews.rating],
        comment = translationRow?.get(ReviewsTranslations.comment) ?: reviewRow[Reviews.comment],
        date = reviewRow[Reviews.date]
    )