package com.rahul.dino.profile

import android.view.View
import com.rahul.dino.profile.databinding.ProfileItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class ProfileItem(val key: String,val  value: String) :
    BindableItem<ProfileItemBinding>() {

    override fun bind(viewBinding: ProfileItemBinding, position: Int) {
        viewBinding.profileKey.text = key
        viewBinding.profileValue.text = value
    }

    override fun getLayout(): Int {
        return R.layout.profile_item
    }

    override fun initializeViewBinding(view: View): ProfileItemBinding {
        return ProfileItemBinding.bind(view)
    }
}