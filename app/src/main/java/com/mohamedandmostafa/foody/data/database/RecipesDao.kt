package com.mohamedandmostafa.foody.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohamedandmostafa.foody.models.FoodRecipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    /** OnConflictStrategy  means that whenever we fetch a new data from our API, we want to replace the old one.*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Query("SELECT * FROM RECIPES_TABLE ORDER BY id ASC")
     fun readRecipes(): Flow<List<RecipesEntity>>
}