package com.rahul.dino.core.ui_utils

import android.content.Context
import android.content.DialogInterface
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rahul.dino.core.R


class DialogExt(val context: Context){
    // Build Error dialog.
    fun buildSingleButtonDialog(error: String, onOkClick: () -> Unit){
        MaterialAlertDialogBuilder(context, R.style.MaterialAlertDialog_OK_color)
                .setTitle("Error")
                .setMessage(error)
                .setPositiveButton("ok"){ _: DialogInterface, _: Int ->
                    onOkClick.invoke()
                }
                .show()
    }
}