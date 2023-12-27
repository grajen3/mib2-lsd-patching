/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelFilterValidity
implements ChannelFilter {
    @Override
    public boolean checkChannel(StationInfo stationInfo) {
        short s;
        boolean bl = false;
        if (stationInfo != null && (s = stationInfo.getStationNumber()) >= 0 && s <= 999) {
            bl = true;
        }
        return bl;
    }
}

