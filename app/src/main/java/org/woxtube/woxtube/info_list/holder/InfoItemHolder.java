package org.woxtube.woxtube.info_list.holder;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.woxtube.woxtube.extractor.InfoItem;
import org.woxtube.woxtube.info_list.InfoItemBuilder;
import org.woxtube.woxtube.local.history.HistoryRecordManager;

/*
 * Created by Christian Schabesberger on 12.02.17.
 *
 * Copyright (C) Christian Schabesberger 2016 <chris.schabesberger@mailbox.org>
 * InfoItemHolder.java is part of WoxTube.
 *
 * WoxTube is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WoxTube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WoxTube.  If not, see <http://www.gnu.org/licenses/>.
 */

public abstract class InfoItemHolder extends RecyclerView.ViewHolder {
    protected final InfoItemBuilder itemBuilder;

    public InfoItemHolder(final InfoItemBuilder infoItemBuilder, final int layoutId,
                          final ViewGroup parent) {
        super(LayoutInflater.from(infoItemBuilder.getContext()).inflate(layoutId, parent, false));
        this.itemBuilder = infoItemBuilder;
    }

    public abstract void updateFromItem(InfoItem infoItem,
                                        HistoryRecordManager historyRecordManager);

    public void updateState(final InfoItem infoItem,
                            final HistoryRecordManager historyRecordManager) { }
}
