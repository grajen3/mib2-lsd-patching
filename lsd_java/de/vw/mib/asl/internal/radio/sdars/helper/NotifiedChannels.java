/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import org.dsi.ifc.sdars.StationInfo;

public final class NotifiedChannels {
    private final SatDb mDb;
    private final StationInfo[] mChannels;

    public NotifiedChannels(SatDb satDb, boolean bl) {
        this.mDb = satDb;
        Object[] objectArray = bl ? satDb.getModelApi().getCategoryListSubItemInfo() : satDb.getModelApi().getChannelListItemInfo();
        this.mChannels = objectArray.length > 0 ? (StationInfo[])objectArray : new StationInfo[0];
    }

    private int oldSize() {
        if (this.mChannels == null) {
            return 0;
        }
        return this.mChannels.length;
    }

    private int getChannelIndex(StationInfo stationInfo) {
        if (this.mChannels != null && stationInfo != null) {
            for (int i2 = 0; i2 < this.mChannels.length; ++i2) {
                if (this.mChannels[i2].stationNumber != stationInfo.stationNumber) continue;
                return i2;
            }
        }
        return -1;
    }

    public StationInfo getChannelByIndex(int n) {
        if (this.mChannels != null && n >= 0 && n < this.mChannels.length) {
            return this.mChannels[n];
        }
        return null;
    }

    public StationInfo nextChannel() {
        return this.step(true);
    }

    public StationInfo previousChannel() {
        return this.step(false);
    }

    public StationInfo step(boolean bl) {
        StationInfo stationInfo;
        int n;
        StationInfo stationInfo2 = null;
        int n2 = this.oldSize();
        if (n2 > 0 && (n = this.getChannelIndex(stationInfo = this.mDb.getPool().getChannel(23))) >= 0) {
            int n3;
            if (bl ? (n3 = n + 1) > this.mChannels.length : (n3 = n - 1) < 0) {
                return null;
            }
            stationInfo2 = this.mChannels[n3];
        }
        return stationInfo2;
    }

    public boolean match(int n, StationInfo stationInfo) {
        StationInfo stationInfo2;
        return stationInfo != null && (stationInfo2 = this.getChannelByIndex(n)) != null && stationInfo2.stationNumber == stationInfo.stationNumber;
    }
}

