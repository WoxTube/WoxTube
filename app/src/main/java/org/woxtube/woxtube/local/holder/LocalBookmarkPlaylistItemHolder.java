package org.woxtube.woxtube.local.holder;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import org.woxtube.woxtube.R;
import org.woxtube.woxtube.database.LocalItem;
import org.woxtube.woxtube.database.playlist.PlaylistMetadataEntry;
import org.woxtube.woxtube.local.LocalItemBuilder;
import org.woxtube.woxtube.local.history.HistoryRecordManager;

import java.time.format.DateTimeFormatter;

public class LocalBookmarkPlaylistItemHolder extends LocalPlaylistItemHolder {
    private final View itemHandleView;

    public LocalBookmarkPlaylistItemHolder(final LocalItemBuilder infoItemBuilder,
                                           final ViewGroup parent) {
        this(infoItemBuilder, R.layout.list_playlist_bookmark_item, parent);
    }

    LocalBookmarkPlaylistItemHolder(final LocalItemBuilder infoItemBuilder, final int layoutId,
                                    final ViewGroup parent) {
        super(infoItemBuilder, layoutId, parent);
        itemHandleView = itemView.findViewById(R.id.itemHandle);
    }

    @Override
    public void updateFromItem(final LocalItem localItem,
                               final HistoryRecordManager historyRecordManager,
                               final DateTimeFormatter dateTimeFormatter) {
        if (!(localItem instanceof PlaylistMetadataEntry)) {
            return;
        }
        final PlaylistMetadataEntry item = (PlaylistMetadataEntry) localItem;

        itemHandleView.setOnTouchListener(getOnTouchListener(item));

        super.updateFromItem(localItem, historyRecordManager, dateTimeFormatter);
    }

    private View.OnTouchListener getOnTouchListener(final PlaylistMetadataEntry item) {
        return (view, motionEvent) -> {
            view.performClick();
            if (itemBuilder != null && itemBuilder.getOnItemSelectedListener() != null
                    && motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN) {
                itemBuilder.getOnItemSelectedListener().drag(item,
                        LocalBookmarkPlaylistItemHolder.this);
            }
            return false;
        };
    }
}
