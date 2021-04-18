package com.rahul.pod.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.pod.dashboard.data.SubCategoryData
import com.rahul.pod.dashboard.databinding.FragmentDashboardBinding
import com.xwray.groupie.GroupieAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCategoryAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initCategoryAdapter() {
        val adapter = GroupieAdapter()
        binding.dashboardRecyclerView.adapter = adapter
        binding.dashboardRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        adapter.add(
            DinoCategoryItem(
                requireContext(), getString(R.string.dashboard_stories), arrayListOf(
                    SubCategoryData(R.drawable.ic_story, getString(R.string.dashboard_all)),
                    SubCategoryData(R.drawable.ic_kid, getString(R.string.dashboard_kids))
                )
            )
        )

        adapter.add(
            DinoCategoryItem(
                requireContext(), getString(R.string.dashboard_videos), arrayListOf(
                    SubCategoryData(R.drawable.ic_movie, getString(R.string.dashboard_all)),
                    SubCategoryData(R.drawable.ic_kid_2, getString(R.string.dashboard_kids))
                )
            )
        )

        adapter.add(
            DinoCategoryItem(
                requireContext(), getString(R.string.dashboard_market_place), arrayListOf(
                    SubCategoryData(R.drawable.ic_market, getString(R.string.dashboard_all)),
                    SubCategoryData(R.drawable.ic_kid_3, getString(R.string.dashboard_kids)),
                    SubCategoryData(R.drawable.ic_coupon, getString(R.string.dashboard_coupons))
                )
            )
        )

    }
}