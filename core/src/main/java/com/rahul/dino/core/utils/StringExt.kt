package com.rahul.dino.core.utils

fun String?.filterEmpty(default: String = ""): String {
    return this ?: default
}

fun String?.validateUserNamePassword(): Boolean {
    return this != null && this.length > 3
}
