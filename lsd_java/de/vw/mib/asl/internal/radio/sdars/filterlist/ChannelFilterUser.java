/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.filterlist;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListModel;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelFilterUser
implements ChannelFilter {
    private final SatFilterListModel mModel;
    private final IAslPool mPool;

    ChannelFilterUser(IAslPool iAslPool, SatFilterListModel satFilterListModel) {
        this.mModel = satFilterListModel;
        this.mPool = this.mModel.getDb().getPool();
    }

    @Override
    public boolean checkChannel(StationInfo stationInfo) {
        boolean bl = false;
        if (stationInfo != null) {
            bl = this.mPool.getBoolean(175) ? (stationInfo.stationNumber == 1 ? true : (stationInfo.stationNumber == 0 ? true : this.mModel.isChannelSelected(stationInfo.stationNumber))) : stationInfo.stationNumber == 1;
        }
        return bl;
    }
}

