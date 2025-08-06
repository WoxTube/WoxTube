package org.woxtube.woxtube.local.holder;

import android.view.ViewGroup;

import org.woxtube.woxtube.R;
import org.woxtube.woxtube.local.LocalItemBuilder;

public class LocalStatisticStreamCardItemHolder extends LocalStatisticStreamItemHolder {
    public LocalStatisticStreamCardItemHolder(final LocalItemBuilder infoItemBuilder,
                                              final ViewGroup parent) {
        super(infoItemBuilder, R.layout.list_stream_card_item, parent);
    }
}
