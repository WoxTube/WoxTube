package org.woxtube.woxtube.database.history.dao;

import org.woxtube.woxtube.database.BasicDAO;

public interface HistoryDAO<T> extends BasicDAO<T> {
    T getLatestEntry();
}
