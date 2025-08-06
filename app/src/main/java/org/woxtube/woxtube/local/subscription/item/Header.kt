package org.woxtube.woxtube.local.subscription.item

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import org.woxtube.woxtube.R
import org.woxtube.woxtube.databinding.SubscriptionHeaderBinding

class Header(private val title: String) : BindableItem<SubscriptionHeaderBinding>() {

    override fun getLayout(): Int = R.layout.subscription_header

    override fun bind(viewBinding: SubscriptionHeaderBinding, position: Int) {
        viewBinding.root.text = title
    }

    override fun initializeViewBinding(view: View) = SubscriptionHeaderBinding.bind(view)
}
