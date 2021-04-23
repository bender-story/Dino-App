package com.rahul.pod.dashboard

import android.view.View
import com.rahul.dino.core.utils.setImageURL
import com.rahul.pod.dashboard.data.SubCategoriesData
import com.rahul.pod.dashboard.databinding.DinoSubCategoryItemBinding
import com.xwray.groupie.viewbinding.BindableItem


class DinoSubCategoryItem(private val subCatergoryData: SubCategoriesData, private val onSelect: () -> Unit ) :
    BindableItem<DinoSubCategoryItemBinding>() {

    override fun bind(viewBinding: DinoSubCategoryItemBinding, position: Int) {
        viewBinding.imageSubCategory.setImageResource(getRandomImage())
        viewBinding.imageDesc.text = subCatergoryData.value
        viewBinding.catergoryItemLayout.setOnClickListener {
            onSelect.invoke()
        }
    }

    override fun getLayout(): Int {
        return R.layout.dino_sub_category_item
    }

    override fun initializeViewBinding(view: View): DinoSubCategoryItemBinding {
        return DinoSubCategoryItemBinding.bind(view)
    }

    private fun getRandomImage(): Int {
        return when((0..6).random()){
            0 -> R.drawable.ic_kid
            1 -> R.drawable.ic_kid_2
            2 -> R.drawable.ic_kid_3
            3 -> R.drawable.ic_coupon
            4 -> R.drawable.ic_market
            5 -> R.drawable.ic_story
            6 -> R.drawable.ic_movie
            else -> R.drawable.ic_market
        }

    }
}