package org.woxtube.woxtube.local.subscription.item

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import org.woxtube.woxtube.R
import org.woxtube.woxtube.databinding.FeedGroupAddNewGridItemBinding

class FeedGroupAddNewGridItem : BindableItem<FeedGroupAddNewGridItemBinding>() {
    override fun getLayout(): Int = R.layout.feed_group_add_new_grid_item
    override fun initializeViewBinding(view: View) = FeedGroupAddNewGridItemBinding.bind(view)
    override fun bind(viewBinding: FeedGroupAddNewGridItemBinding, position: Int) {
        // this is a static item, nothing to do here
    }
}
