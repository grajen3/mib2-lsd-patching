/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.filterlist;

import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListModel;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatIntSet;

public final class SatFilterListApi {
    private final SatDb mDb;
    private SatFilterListModel mModel;

    public SatFilterListApi(SatDb satDb) {
        this.mDb = satDb;
        if (this.mModel == null) {
            this.mModel = new SatFilterListModel(this.mDb);
        }
    }

    public void startModule() {
        if (null != this.mModel) {
            this.mModel.start();
        }
    }

    public int getCategoryStatus(short s) {
        if (null != this.mModel) {
            return this.mModel.getCategoryStatus(s);
        }
        return 2;
    }

    public boolean isChannelSelected(short s) {
        if (null != this.mModel) {
            return this.mModel.isChannelSelected(s);
        }
        return false;
    }

    public void clear() {
        if (null != this.mModel) {
            this.mModel.clear();
        }
    }

    public ChannelFilter getUserChannelFilter() {
        if (null != this.mModel) {
            return this.mModel.getUserChannelFilter();
        }
        return null;
    }

    public void channelListFilterDefaultSetting() {
        if (null != this.mModel) {
            this.mModel.defaultSettingForChannelFilter();
        }
    }

    public SatIntSet getSkippedChannels() {
        if (null != this.mModel) {
            return this.mModel.getSkippedChannels();
        }
        return null;
    }

    public SatIntSet getNonSkippedChannels() {
        if (null != this.mModel) {
            return this.mModel.getNonSkippedChannels();
        }
        return null;
    }

    public void resetSettings() {
        if (null != this.mModel) {
            this.mModel.resetSettings();
        }
    }
}

