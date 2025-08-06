package org.woxtube.woxtube.settings.preferencesearch;

import androidx.annotation.NonNull;

public interface PreferenceSearchResultListener {
    void onSearchResultClicked(@NonNull PreferenceSearchItem result);
}
