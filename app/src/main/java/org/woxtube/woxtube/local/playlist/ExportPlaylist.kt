package org.woxtube.woxtube.local.playlist

import android.content.Context
import org.woxtube.woxtube.R
import org.woxtube.woxtube.database.playlist.PlaylistStreamEntry
import org.woxtube.woxtube.extractor.exceptions.ParsingException
import org.woxtube.woxtube.extractor.services.youtube.linkHandler.YoutubeStreamLinkHandlerFactory
import org.woxtube.woxtube.local.playlist.PlayListShareMode.JUST_URLS
import org.woxtube.woxtube.local.playlist.PlayListShareMode.WITH_TITLES
import org.woxtube.woxtube.local.playlist.PlayListShareMode.YOUTUBE_TEMP_PLAYLIST

fun export(
    shareMode: PlayListShareMode,
    playlist: List<PlaylistStreamEntry>,
    context: Context
): String {
    return when (shareMode) {
        WITH_TITLES -> exportWithTitles(playlist, context)
        JUST_URLS -> exportJustUrls(playlist)
        YOUTUBE_TEMP_PLAYLIST -> exportAsYoutubeTempPlaylist(playlist)
    }
}

fun exportWithTitles(
    playlist: List<PlaylistStreamEntry>,
    context: Context
): String {

    return playlist.asSequence()
        .map { it.streamEntity }
        .map { entity ->
            context.getString(
                R.string.video_details_list_item,
                entity.title,
                entity.url
            )
        }
        .joinToString(separator = "\n")
}

fun exportJustUrls(playlist: List<PlaylistStreamEntry>): String {

    return playlist.asSequence()
        .map { it.streamEntity.url }
        .joinToString(separator = "\n")
}

fun exportAsYoutubeTempPlaylist(playlist: List<PlaylistStreamEntry>): String {

    val videoIDs = playlist.asReversed().asSequence()
        .map { it.streamEntity.url }
        .mapNotNull(::getYouTubeId)
        .take(50) // YouTube limitation: temp playlists can't have more than 50 items
        .toList()
        .asReversed()
        .joinToString(separator = ",")

    return "https://www.youtube.com/watch_videos?video_ids=$videoIDs"
}

val linkHandler: YoutubeStreamLinkHandlerFactory = YoutubeStreamLinkHandlerFactory.getInstance()

/**
 * Gets the video id from a YouTube URL.
 *
 * @param url YouTube URL
 * @return the video id
 */
fun getYouTubeId(url: String): String? {

    return try { linkHandler.getId(url) } catch (e: ParsingException) { null }
}
