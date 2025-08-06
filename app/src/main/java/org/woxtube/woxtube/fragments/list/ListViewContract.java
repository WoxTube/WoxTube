package org.woxtube.woxtube.fragments.list;

import org.woxtube.woxtube.fragments.ViewContract;

public interface ListViewContract<I, N> extends ViewContract<I> {
    void showListFooter(boolean show);

    void handleNextItems(N result);
}
