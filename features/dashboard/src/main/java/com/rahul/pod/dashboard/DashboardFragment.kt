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
import com.rahul.dino.navigation.NavigationType
import com.rahul.pod.dashboard.data.CategoryDataResponse
import com.rahul.pod.dashboard.databinding.FragmentDashboardBinding
import com.xwray.groupie.GroupieAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    private val appNavigationViewModel : AppNavigationViewModel by sharedViewModel()
    private val viewModel : DashboardViewModel by sharedViewModel()
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater,container,false)
        _binding!!.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAppBarClick()
        initObservers()
        fetchDashboardData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun fetchDashboardData(){
        viewModel.getDashBoardData()
    }

    private fun initObservers() {
        viewModel.categoryData.observe(viewLifecycleOwner){
            initCategoryAdapter(it)
        }

        viewModel.errorEvent.observe(viewLifecycleOwner){
            DialogExt(requireContext()).buildSingleButtonDialog(getString(R.string.error)){}
        }
    }

    private fun initCategoryAdapter(categoryDataResponse: CategoryDataResponse) {
        val adapter = GroupieAdapter()
        binding.dashboardRecyclerView.adapter = adapter
        binding.dashboardRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())


        categoryDataResponse.categories.forEach {
            adapter.add(
                DinoCategoryItem(
                    requireContext(),it){initCategoryClick()}
            )
        }


    }

    private fun initCategoryClick(){
        appNavigationViewModel.onNavigationClicked(NavigationType.CATEGORY)
    }

    private fun initAppBarClick(){
        binding.dashBoardAppBar.setOnMenuClickListener(object : CommonAppBarActions{
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