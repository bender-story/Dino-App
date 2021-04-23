package com.rahul.pod.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.dino.core.ui_utils.DialogExt
import com.rahul.dino.core.utils.filterEmpty
import com.rahul.dino.navigation.NavigationConstants
import com.rahul.pod.categories.data.CategoryDataResponse
import com.rahul.pod.categories.databinding.FragmentCategoryBinding
import com.xwray.groupie.GroupieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {

    private val viewModel by viewModel<CategoryViewModel>()
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        _binding!!.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        fetchCategoryData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun fetchCategoryData() {
        val bundle = this.arguments
        viewModel.getCategoryData(
           getParentCategory(bundle?.getString(NavigationConstants.CATEGORY_EXTRA).toString().filterEmpty()).toLowerCase(),
            bundle?.getString(NavigationConstants.SUB_CATEGORY_EXTRA).toString().filterEmpty().toLowerCase()
        )
    }

    private fun initObservers() {
        viewModel.categoryData.observe(viewLifecycleOwner) {
            initCategoryAdapter(it)
        }

        viewModel.errorEvent.observe(viewLifecycleOwner) {
            DialogExt(requireContext()).buildSingleButtonDialog(getString(R.string.error)) {}
        }
    }

    private fun initCategoryAdapter(categoryDataResponse: CategoryDataResponse) {
        val adapter = GroupieAdapter()
        binding.categoryRecyclerView.adapter = adapter
        binding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        categoryDataResponse.results.forEach {
            adapter.add(
                CategoryItem(it)
            )
        }
    }

    // Work around as I had issue updating values of the url on the server
    private fun getParentCategory(parentCategory: String): String {
        return if(parentCategory == getString(R.string.dashboard_market_place)) "mp" else parentCategory
    }

}