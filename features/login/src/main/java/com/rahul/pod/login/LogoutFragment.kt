package com.rahul.pod.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.rahul.dino.navigation.AppNavigationViewModel
import com.rahul.dino.navigation.NavigationType
import com.rahul.pod.login.databinding.FragmentLoginBinding
import com.rahul.pod.login.databinding.FragmentLogoutBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LogoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LogoutFragment : Fragment() {

    private val appNavigationViewModel: AppNavigationViewModel by sharedViewModel()
    private var _binding: FragmentLogoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLoginButtonClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initLoginButtonClick() {
        binding.loginAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_logout_to_login, null, navOptions { popUpTo(R.id.nav_graph_logout) { inclusive = false } })
        }
    }

}