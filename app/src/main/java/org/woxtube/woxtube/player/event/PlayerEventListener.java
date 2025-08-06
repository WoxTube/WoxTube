package org.woxtube.woxtube.player.event;

import com.google.android.exoplayer2.PlaybackParameters;

import org.woxtube.woxtube.extractor.stream.StreamInfo;
import org.woxtube.woxtube.player.playqueue.PlayQueue;

public interface PlayerEventListener {
    void onQueueUpdate(PlayQueue queue);
    void onPlaybackUpdate(int state, int repeatMode, boolean shuffled,
                          PlaybackParameters parameters);
    void onProgressUpdate(int currentProgress, int duration, int bufferPercent);
    void onMetadataUpdate(StreamInfo info, PlayQueue queue);
    default void onAudioTrackUpdate() { }
    void onServiceStopped();
}
