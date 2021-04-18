package com.rahul.pod.categories

import android.view.View
import com.rahul.pod.categories.databinding.CategoryItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class CategoryItem :
    BindableItem<CategoryItemBinding>() {

    override fun bind(viewBinding: CategoryItemBinding, position: Int) {
    }

    override fun getLayout(): Int {
        return R.layout.category_item
    }

    override fun initializeViewBinding(view: View): CategoryItemBinding {
        return CategoryItemBinding.bind(view)
    }
}