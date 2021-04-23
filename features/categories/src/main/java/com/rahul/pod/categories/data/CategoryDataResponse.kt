package com.rahul.pod.categories.data

data class CategoryDataResponse(
    val results: List<Result>
)

data class Result(
    val id: Int,
    val link: String,
    val overview: String,
    val poster_path: String,
    val title: String
)