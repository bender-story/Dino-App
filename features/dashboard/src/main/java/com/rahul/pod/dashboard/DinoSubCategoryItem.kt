package com.rahul.pod.dashboard

import android.view.View
import com.rahul.pod.dashboard.data.SubCategoryData
import com.rahul.pod.dashboard.databinding.DinoSubCategoryItemBinding
import com.xwray.groupie.viewbinding.BindableItem


class DinoSubCategoryItem(private val subCatergoryData: SubCategoryData,  private val onSelect: () -> Unit ) :
    BindableItem<DinoSubCategoryItemBinding>() {

    override fun bind(viewBinding: DinoSubCategoryItemBinding, position: Int) {
        subCatergoryData.imageURL?.let { viewBinding.imageSubCategory.setImageResource(it) }
        viewBinding.imageDesc.text = subCatergoryData.imageDesc
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
}