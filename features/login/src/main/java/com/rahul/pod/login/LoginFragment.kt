package com.rahul.pod.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahul.dino.navigation.AppNavigationViewModel
import com.rahul.dino.navigation.NavigationType
import com.rahul.pod.login.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private val appNavigationViewModel : AppNavigationViewModel by sharedViewModel()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
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

    private fun initLoginButtonClick(){
        binding.loginButton.setOnClickListener {
            appNavigationViewModel.onNavigationClicked(NavigationType.DASHBOARD)
        }
    }
}