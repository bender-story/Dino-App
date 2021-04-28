package com.rahul.pod.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.rahul.dino.navigation.AppNavigator
import com.rahul.dino.navigation.NavigationType
import com.rahul.pod.login.databinding.FragmentLogoutBinding
import org.koin.android.ext.android.inject


/**
 * A simple [Fragment] subclass.
 * Use the [LogoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LogoutFragment : Fragment() {

    private val appNavigator: AppNavigator by inject()
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
            appNavigator.onNavigationClicked(NavigationType.LOGIN)
        }
    }

}