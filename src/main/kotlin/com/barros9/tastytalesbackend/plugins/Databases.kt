package com.barros9.tastytalesbackend.plugins

import com.barros9.tastytalesbackend.fake.addRecipeCarbonara
import com.barros9.tastytalesbackend.fake.addRecipeChickenCurry
import com.barros9.tastytalesbackend.fake.addRecipeMargheritaPizza
import com.barros9.tastytalesbackend.schema.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun connectDatabase() {
    Database.connect(
        url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
        user = "root",
        driver = "org.h2.Driver",
        password = "",
    )

    transaction {
        SchemaUtils.create(
            Recipes,
            RecipesTranslations,
            Ingredients,
            IngredientsTranslations,
            Instructions,
            InstructionsTranslations,
            Reviews,
            ReviewsTranslations
        )
    }

    addRecipeCarbonara()
    addRecipeMargheritaPizza()
    addRecipeChickenCurry()
}
