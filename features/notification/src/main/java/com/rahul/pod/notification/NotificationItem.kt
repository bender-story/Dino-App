package com.rahul.pod.notification

import android.view.View
import com.rahul.pod.notification.databinding.NotificationItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class NotificationItem(val header: String,val  desc: String) :
    BindableItem<NotificationItemBinding>() {

    override fun bind(viewBinding: NotificationItemBinding, position: Int) {
        viewBinding.notificationHead.text = header
        viewBinding.notificationDesc.text = desc
    }

    override fun getLayout(): Int {
        return R.layout.notification_item
    }

    override fun initializeViewBinding(view: View): NotificationItemBinding {
        return NotificationItemBinding.bind(view)
    }
}