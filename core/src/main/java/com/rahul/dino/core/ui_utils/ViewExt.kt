package com.rahul.dino.core.utils

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Method gets the Image from the path specified in the parameter
 * this also circle crops the Image.
 * @param path  image url
 */
@BindingAdapter("setImageURL")
fun AppCompatImageView.setImageURL(path: String?) {
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


/**
 * Make View visible and Gone
 * @param visible  when true it is visble else its gone
 */
@BindingAdapter("makeVisible")
fun View.makeVisible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}