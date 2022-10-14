package com.mohamedandmostafa.foody.data

import com.mohamedandmostafa.foody.data.network.FoodRecipesApi
import com.mohamedandmostafa.foody.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun gerRecipes(queries: Map<String, String>):Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)

    }

}