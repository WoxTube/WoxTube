package org.woxtube.woxtube.database.playlist;

import androidx.annotation.Nullable;

import org.woxtube.woxtube.database.LocalItem;

public interface PlaylistLocalItem extends LocalItem {
    String getOrderingName();

    long getDisplayIndex();

    long getUid();

    void setDisplayIndex(long displayIndex);

    @Nullable
    String getThumbnailUrl();
}
