package com.rahul.pod.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahul.dino.core.ui_utils.DialogExt
import com.rahul.dino.core.utils.filterEmpty
import com.rahul.dino.core.utils.validateUserNamePassword
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
    private val loginViewModel : LoginViewModel by sharedViewModel()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        _binding!!.viewModel = loginViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initLoginButtonClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initObservers() {
        loginViewModel.loginSuccessEvent.observe(viewLifecycleOwner){
            appNavigationViewModel.onNavigationClicked(NavigationType.DASHBOARD)
        }

        loginViewModel.loginErrorEvent.observe(viewLifecycleOwner){
            DialogExt(requireContext()).buildSingleButtonDialog(getString(R.string.login_error)){}
        }
    }

    private fun initLoginButtonClick(){
        binding.loginButton.setOnClickListener {
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()
            if(userName.validateUserNamePassword() && password.validateUserNamePassword())
            loginViewModel.login(binding.userName.text.toString().filterEmpty(),binding.password.text.toString().filterEmpty())
            else DialogExt(requireContext()).buildSingleButtonDialog(getString(R.string.login_error_empty)){}
        }
    }
}