package com.rahul.dino.core.utils

fun String?.filterEmpty(default: String = ""): String {
     return this ?: default
}