package com.rahul.dino.core.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Method gets the Image from the path specified in the parameter
 * this also circle crops the Image.
 * @param path  image url
 */
@BindingAdapter("getImage")
fun AppCompatImageView.getImage(path: String?) {
    Glide.with(this.context).load(path).into(this)
}

@BindingAdapter("roundedImge")
fun AppCompatImageView.getRoundedImage(id: Int?) {
    Glide
        .with(this.context)
        .load(id)
        .circleCrop()
        .into(this)
}