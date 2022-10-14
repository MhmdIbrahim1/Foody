package com.mohamedandmostafa.foody.ui.fragments.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamedandmostafa.foody.viewmodels.MainViewModel
import com.mohamedandmostafa.foody.R
import com.mohamedandmostafa.foody.adapters.RecipesAdapter
import com.mohamedandmostafa.foody.util.NetworkResult
import com.mohamedandmostafa.foody.viewmodels.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recipes.view.*

@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var recipesViewModel: RecipesViewModel
    private lateinit var mView: View
    private val mAdapter by lazy { RecipesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        recipesViewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         mView =  inflater.inflate(R.layout.fragment_recipes, container, false)


        setUpRecyclerView()
        requestApiData()

        return mView
    }

    private fun requestApiData(){

        mainViewModel.getRecipes(recipesViewModel.applyQueries())
        mainViewModel.recipesResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    hideShimmerEffect()
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    hideShimmerEffect()
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
                is NetworkResult.Loading ->
                    showShimmerEffect()
            }
        }

        }


    private fun setUpRecyclerView() {
        mView.recycler_view.adapter = mAdapter
        mView.recycler_view.layoutManager = LinearLayoutManager(requireContext())
        showShimmerEffect()
    }
    private fun showShimmerEffect(){

        mView.recycler_view.showShimmer()
    }
    private fun hideShimmerEffect(){
        mView.recycler_view.hideShimmer()
    }





}