package com.mohamedandmostafa.foody.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohamedandmostafa.foody.models.FoodRecipe
import com.mohamedandmostafa.foody.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
   var foodRecipe: FoodRecipe
){


    @PrimaryKey(autoGenerate = false)
    var id : Int = 0

}