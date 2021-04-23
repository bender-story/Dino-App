package com.rahul.pod.categories

import android.view.View
import com.rahul.dino.core.utils.setImageURL
import com.rahul.pod.categories.data.CategoryDataResponse
import com.rahul.pod.categories.data.Result
import com.rahul.pod.categories.databinding.CategoryItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class CategoryItem(private val data: Result) :
    BindableItem<CategoryItemBinding>() {

    override fun bind(viewBinding: CategoryItemBinding, position: Int) {
        viewBinding.categoryImage.setImageURL(data.poster_path)
        viewBinding.categoryTitle.text = data.title
        viewBinding.overView.text=data.overview
    }

    override fun getLayout(): Int {
        return R.layout.category_item
    }

    override fun initializeViewBinding(view: View): CategoryItemBinding {
        return CategoryItemBinding.bind(view)
    }
}