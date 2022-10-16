package com.mohamedandmostafa.foody.util

class Constants {

    companion object{
        const val BASE_URL = "https://api.spoonacular.com"
        const val API_KEY = "2ca3638fa6f54eabb7173c6a1585bc59"

        // API Query Keys
        const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY = "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

        // Room DataBase
        const val DATABASE_NAME = "recipes_database"
        const val RECIPES_TABLE = "recipes_table"


    }
}