package com.rahul.dino.core.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.appbar.AppBarLayout
import com.rahul.dino.core.R
import com.rahul.dino.core.databinding.CommonAppBarBinding

class CommonAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppBarLayout(context, attrs, defStyleAttr) {

    var commonAppBarActions: CommonAppBarActions? = null

    private var binding: CommonAppBarBinding =
        CommonAppBarBinding.inflate(LayoutInflater.from(context), this)

    init {
        this.outlineProvider = null
        this.fitsSystemWindows = true
        initProfileClick()
        initMenuClick()
    }

    private fun initProfileClick() {
        binding.profileImageView.setOnClickListener {
            commonAppBarActions?.onProfileClick()
        }
    }

    private fun initMenuClick() {
        binding.commonToolBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notify -> {
                    commonAppBarActions?.onNotifyClick()
                    true
                }
                R.id.logout -> {
                    commonAppBarActions?.onLogoutClick()
                    true
                }
                else -> false
            }

        }
    }

}
