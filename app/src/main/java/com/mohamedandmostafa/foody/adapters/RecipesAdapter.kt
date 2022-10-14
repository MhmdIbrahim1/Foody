package com.mohamedandmostafa.foody.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mohamedandmostafa.foody.databinding.RecipesRowLayoutBinding
import com.mohamedandmostafa.foody.models.FoodRecipe
import com.mohamedandmostafa.foody.util.RecipesDiffUtil
import com.mohamedandmostafa.foody.models.Result

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipes = emptyList<Result>()

    class MyViewHolder(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /** this fun will update the layout whenever there is a change inside data*/
            fun bind(result: Result){
                binding.result = result
                binding.executePendingBindings()
            }
        companion object{
            /** this fun we're basically returning this class which created*/
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater,parent,false)
                return MyViewHolder(binding)
            }
        }
    }

    /** in fun onCreateViewHolder we're basically receiving the parent in 'from' fun*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        /** inside this var we're storing a current item from recyclerview using position parameter to get dynamically position for the row*/
        val currentRecipe = recipes[position]
        holder.bind(currentRecipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    /** basically we're going to call this function from our recipes fragment and we're going to pass a new data to this function every time and every time there is a new data from this from this function. "and  store that new data inside this recipe emptyList, which we have created inside our recipes adaptor".*/
    fun setData(newData: FoodRecipe){
        val recipesDiffUtil = RecipesDiffUtil(recipes, newData.results)
        val toDoDiffResult = DiffUtil.calculateDiff(recipesDiffUtil)
        recipes = newData.results
        toDoDiffResult.dispatchUpdatesTo(this)
    }
}