package org.woxtube.woxtube.local.feed.service

data class FeedLoadState(
    val updateDescription: String,
    val maxProgress: Int,
    val currentProgress: Int,
)
