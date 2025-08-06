package org.woxtube.woxtube.util.debounce;

import org.woxtube.woxtube.error.ErrorInfo;

public interface DebounceSavable {

    /**
     * Execute operations to save the data. <br>
     * Must set {@link DebounceSaver#setIsModified(boolean)} false in this method manually
     * after the data has been saved.
     */
    void saveImmediate();

    void showError(ErrorInfo errorInfo);
}
