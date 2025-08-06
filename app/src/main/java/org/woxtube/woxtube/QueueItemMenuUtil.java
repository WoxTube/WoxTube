package org.woxtube.woxtube;

import static org.woxtube.woxtube.util.SparseItemUtil.fetchStreamInfoAndSaveToDatabase;
import static org.woxtube.woxtube.util.external_communication.ShareUtils.shareText;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.PopupMenu;

import androidx.fragment.app.FragmentManager;

import org.woxtube.woxtube.database.stream.model.StreamEntity;
import org.woxtube.woxtube.download.DownloadDialog;
import org.woxtube.woxtube.local.dialog.PlaylistDialog;
import org.woxtube.woxtube.player.playqueue.PlayQueue;
import org.woxtube.woxtube.player.playqueue.PlayQueueItem;
import org.woxtube.woxtube.util.NavigationHelper;
import org.woxtube.woxtube.util.SparseItemUtil;

import java.util.List;

public final class QueueItemMenuUtil {
    private QueueItemMenuUtil() {
    }

    public static void openPopupMenu(final PlayQueue playQueue,
                                     final PlayQueueItem item,
                                     final View view,
                                     final boolean hideDetails,
                                     final FragmentManager fragmentManager,
                                     final Context context) {
        final ContextThemeWrapper themeWrapper =
                new ContextThemeWrapper(context, R.style.DarkPopupMenu);

        final PopupMenu popupMenu = new PopupMenu(themeWrapper, view);
        popupMenu.inflate(R.menu.menu_play_queue_item);

        if (hideDetails) {
            popupMenu.getMenu().findItem(R.id.menu_item_details).setVisible(false);
        }

        popupMenu.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menu_item_remove:
                    final int index = playQueue.indexOf(item);
                    playQueue.remove(index);
                    return true;
                case R.id.menu_item_details:
                    // playQueue is null since we don't want any queue change
                    NavigationHelper.openVideoDetail(context, item.getServiceId(),
                            item.getUrl(), item.getTitle(), null,
                            false);
                    return true;
                case R.id.menu_item_append_playlist:
                    PlaylistDialog.createCorrespondingDialog(
                            context,
                            List.of(new StreamEntity(item)),
                            dialog -> dialog.show(
                                    fragmentManager,
                                    "QueueItemMenuUtil@append_playlist"
                            )
                    );

                    return true;
                case R.id.menu_item_channel_details:
                    SparseItemUtil.fetchUploaderUrlIfSparse(context, item.getServiceId(),
                            item.getUrl(), item.getUploaderUrl(),
                            // An intent must be used here.
                            // Opening with FragmentManager transactions is not working,
                            // as PlayQueueActivity doesn't use fragments.
                            uploaderUrl -> NavigationHelper.openChannelFragmentUsingIntent(
                                    context, item.getServiceId(), uploaderUrl, item.getUploader()
                            ));
                    return true;
                case R.id.menu_item_share:
                    shareText(context, item.getTitle(), item.getUrl(),
                            item.getThumbnails());
                    return true;
                case R.id.menu_item_download:
                    fetchStreamInfoAndSaveToDatabase(context, item.getServiceId(), item.getUrl(),
                            info -> {
                                final DownloadDialog downloadDialog = new DownloadDialog(context,
                                        info);
                                downloadDialog.show(fragmentManager, "downloadDialog");
                            });
                    return true;
            }
            return false;
        });

        popupMenu.show();
    }
}
