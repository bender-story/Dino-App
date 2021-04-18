package com.rahul.pod.dashboard.data

data class CategoryData(
    val title: String?,
    val subCategoryList: List<SubCategoryData>?
)

data class SubCategoryData(
    val imageURL: Int?,
    val imageDesc: String?
)
