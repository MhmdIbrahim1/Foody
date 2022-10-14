package com.mohamedandmostafa.foody.util

import androidx.recyclerview.widget.DiffUtil
import com.mohamedandmostafa.foody.models.Result

class RecipesDiffUtil(
    private val oldList: List<Result>,
    private val newList: List<Result>
):DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    /** Called by DiffUtil to decide whether two object represent the same item.if items have unique ids, this method should check their id equality*/
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

/** Check whether two items have the same data. Can change its behavior depending on the UI. this method called by DiffUtil only*/

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}