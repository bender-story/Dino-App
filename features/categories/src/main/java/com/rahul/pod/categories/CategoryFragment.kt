package com.rahul.pod.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.pod.categories.databinding.FragmentCategoryBinding
import com.xwray.groupie.GroupieAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {


    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater,container,false)
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
        binding.categoryRecyclerView.adapter = adapter
        binding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        adapter.add(
            CategoryItem()
        )

        adapter.add(
            CategoryItem()
        )

        adapter.add(
            CategoryItem()
        )

        adapter.add(
            CategoryItem()
        )

    }

}