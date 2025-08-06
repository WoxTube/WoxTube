package org.woxtube.woxtube.database;

import static org.woxtube.woxtube.database.Migrations.DB_VER_9;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.woxtube.woxtube.database.feed.dao.FeedDAO;
import org.woxtube.woxtube.database.feed.dao.FeedGroupDAO;
import org.woxtube.woxtube.database.feed.model.FeedEntity;
import org.woxtube.woxtube.database.feed.model.FeedGroupEntity;
import org.woxtube.woxtube.database.feed.model.FeedGroupSubscriptionEntity;
import org.woxtube.woxtube.database.feed.model.FeedLastUpdatedEntity;
import org.woxtube.woxtube.database.history.dao.SearchHistoryDAO;
import org.woxtube.woxtube.database.history.dao.StreamHistoryDAO;
import org.woxtube.woxtube.database.history.model.SearchHistoryEntry;
import org.woxtube.woxtube.database.history.model.StreamHistoryEntity;
import org.woxtube.woxtube.database.playlist.dao.PlaylistDAO;
import org.woxtube.woxtube.database.playlist.dao.PlaylistRemoteDAO;
import org.woxtube.woxtube.database.playlist.dao.PlaylistStreamDAO;
import org.woxtube.woxtube.database.playlist.model.PlaylistEntity;
import org.woxtube.woxtube.database.playlist.model.PlaylistRemoteEntity;
import org.woxtube.woxtube.database.playlist.model.PlaylistStreamEntity;
import org.woxtube.woxtube.database.stream.dao.StreamDAO;
import org.woxtube.woxtube.database.stream.dao.StreamStateDAO;
import org.woxtube.woxtube.database.stream.model.StreamEntity;
import org.woxtube.woxtube.database.stream.model.StreamStateEntity;
import org.woxtube.woxtube.database.subscription.SubscriptionDAO;
import org.woxtube.woxtube.database.subscription.SubscriptionEntity;

@TypeConverters({Converters.class})
@Database(
        entities = {
                SubscriptionEntity.class, SearchHistoryEntry.class,
                StreamEntity.class, StreamHistoryEntity.class, StreamStateEntity.class,
                PlaylistEntity.class, PlaylistStreamEntity.class, PlaylistRemoteEntity.class,
                FeedEntity.class, FeedGroupEntity.class, FeedGroupSubscriptionEntity.class,
                FeedLastUpdatedEntity.class
        },
        version = DB_VER_9
)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "newpipe.db";

    public abstract SearchHistoryDAO searchHistoryDAO();

    public abstract StreamDAO streamDAO();

    public abstract StreamHistoryDAO streamHistoryDAO();

    public abstract StreamStateDAO streamStateDAO();

    public abstract PlaylistDAO playlistDAO();

    public abstract PlaylistStreamDAO playlistStreamDAO();

    public abstract PlaylistRemoteDAO playlistRemoteDAO();

    public abstract FeedDAO feedDAO();

    public abstract FeedGroupDAO feedGroupDAO();

    public abstract SubscriptionDAO subscriptionDAO();
}
