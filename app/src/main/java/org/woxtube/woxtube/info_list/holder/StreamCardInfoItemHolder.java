package org.woxtube.woxtube.info_list.holder;

import android.view.ViewGroup;

import org.woxtube.woxtube.R;
import org.woxtube.woxtube.info_list.InfoItemBuilder;

/**
 * Card layout for stream.
 */
public class StreamCardInfoItemHolder extends StreamInfoItemHolder {

    public StreamCardInfoItemHolder(final InfoItemBuilder infoItemBuilder, final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_stream_card_item, parent);
    }
}
