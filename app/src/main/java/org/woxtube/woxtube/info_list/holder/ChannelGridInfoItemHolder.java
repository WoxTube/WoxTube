package org.woxtube.woxtube.info_list.holder;

import android.view.ViewGroup;

import org.woxtube.woxtube.R;
import org.woxtube.woxtube.info_list.InfoItemBuilder;

public class ChannelGridInfoItemHolder extends ChannelMiniInfoItemHolder {
    public ChannelGridInfoItemHolder(final InfoItemBuilder infoItemBuilder,
                                     final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_channel_grid_item, parent);
    }
}
