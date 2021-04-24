package com.rahul.pod.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.dino.core.ui.CommonAppBarActions
import com.rahul.dino.core.ui_utils.DialogExt
import com.rahul.dino.navigation.AppNavigationViewModel
import com.rahul.dino.navigation.NavigationConstants
import com.rahul.dino.navigation.NavigationType
import com.rahul.pod.dashboard.data.AllCategoriesDataResponse
import com.rahul.pod.dashboard.databinding.FragmentDashboardBinding
import com.xwray.groupie.GroupieAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    private val appNavigationViewModel: AppNavigationViewModel by sharedViewModel()
    private val viewModel: DashboardViewModel by sharedViewModel()
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private var initialized = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        _binding!!.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppBarClick()
        initObservers()
        if(!initialized) {
            fetchDashboardData()
            initialized = true
        }else{
            viewModel.allCategoriesData.value?.let { initCategoryAdapter(it) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun fetchDashboardData() {
        viewModel.getDashBoardData()
    }

    private fun initObservers() {
        viewModel.allCategoriesData.observe(viewLifecycleOwner) {
            initCategoryAdapter(it)
        }

        viewModel.errorEvent.observe(viewLifecycleOwner) {
            DialogExt(requireContext()).buildSingleButtonDialog(getString(R.string.error)) {}
        }
    }

    private fun initCategoryAdapter(allCategoriesDataResponse: AllCategoriesDataResponse) {
        val adapter = GroupieAdapter()
        binding.dashboardRecyclerView.adapter = adapter
        binding.dashboardRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())


        allCategoriesDataResponse.categories.forEach {
            adapter.add(
                DinoCategoryItem(
                    requireContext(), it
                ) { category, subCategory ->
                    initCategoryClick(category, subCategory)
                }
            )
        }


    }

    private fun initCategoryClick(category: String, subCategory: String) {
        val bundle = Bundle()
        bundle.putString(NavigationConstants.CATEGORY_EXTRA, category)
        bundle.putString(NavigationConstants.SUB_CATEGORY_EXTRA, subCategory)
        appNavigationViewModel.onNavigationClicked(NavigationType.CATEGORY,bundle)
    }

    private fun initAppBarClick() {
        binding.dashBoardAppBar.setOnMenuClickListener(object : CommonAppBarActions {
            override fun onNotifyClick() {
                appNavigationViewModel.onNavigationClicked(NavigationType.NOTIFICATION)
            }

            override fun onProfileClick() {
                appNavigationViewModel.onNavigationClicked(NavigationType.PROFILE)
            }

            override fun onLogoutClick() {
                appNavigationViewModel.onNavigationClicked(NavigationType.LOGOUT)
            }

        })
    }

}