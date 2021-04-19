package com.rahul.pod.dashboard

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.pod.dashboard.data.SubCategoryData
import com.rahul.pod.dashboard.databinding.DinoCategoryItemBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class DinoCategoryItem(
    private val context: Context,
    private val headerText: String,
    private val subCatergoryList: ArrayList<SubCategoryData>,
    private val onItemSelected: () -> Unit
) :
    BindableItem<DinoCategoryItemBinding>() {

    override fun bind(viewBinding: DinoCategoryItemBinding, position: Int) {
        viewBinding.categoryHeader.text = headerText
        initAdapter(viewBinding)
    }

    override fun getLayout(): Int {
        return R.layout.dino_category_item
    }

    override fun initializeViewBinding(view: View): DinoCategoryItemBinding {
        return DinoCategoryItemBinding.bind(view)
    }

    private fun initAdapter(viewBinding: DinoCategoryItemBinding) {
        val adapter = GroupieAdapter()
        viewBinding.dinoCategoryRecyclerView.adapter = adapter
        viewBinding.dinoCategoryRecyclerView.layoutManager =
            GridLayoutManager(context, 3)

        subCatergoryList.forEach {
            adapter.add(DinoSubCategoryItem(it){
                onItemSelected.invoke()
            })
        }
    }
}