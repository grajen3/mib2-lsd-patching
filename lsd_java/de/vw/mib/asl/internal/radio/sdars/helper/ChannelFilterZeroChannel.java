/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelFilterZeroChannel
implements ChannelFilter {
    @Override
    public boolean checkChannel(StationInfo stationInfo) {
        boolean bl = false;
        if (stationInfo != null && stationInfo.stationNumber != 0) {
            return true;
        }
        return bl;
    }
}

