package org.woxtube.woxtube.fragments.list.videos;

import org.woxtube.woxtube.extractor.InfoItem;
import org.woxtube.woxtube.extractor.ListInfo;
import org.woxtube.woxtube.extractor.linkhandler.ListLinkHandler;
import org.woxtube.woxtube.extractor.stream.StreamInfo;

import java.util.ArrayList;
import java.util.Collections;

public final class RelatedItemsInfo extends ListInfo<InfoItem> {
    /**
     * This class is used to wrap the related items of a StreamInfo into a ListInfo object.
     *
     * @param info the stream info from which to get related items
     */
    public RelatedItemsInfo(final StreamInfo info) {
        super(info.getServiceId(), new ListLinkHandler(info.getOriginalUrl(), info.getUrl(),
                info.getId(), Collections.emptyList(), null), info.getName());
        setRelatedItems(new ArrayList<>(info.getRelatedItems()));
    }
}
