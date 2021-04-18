package com.rahul.dino.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.dino.profile.databinding.FragmentProfileBinding
import com.xwray.groupie.GroupieAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
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
        binding.profileRecyclerView.adapter = adapter
        binding.profileRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        adapter.add(
            ProfileItem("Name","Rahul")
        )

        adapter.add(
            ProfileItem("ID","GDSHD88998")
        )

        adapter.add(
            ProfileItem("Country","Singapore")
        )

        adapter.add(
            ProfileItem("Phone No","83382626")
        )

        adapter.add(
            ProfileItem("Email","sample@gmail.com")
        )

    }
}