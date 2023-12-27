/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelFilterSubscription
implements ChannelFilter {
    @Override
    public boolean checkChannel(StationInfo stationInfo) {
        boolean bl = false;
        if (stationInfo != null && (SatConfig.mShowUnsubscribed || SatConfig.mShowEveryChannel || stationInfo.subscription == 2 || stationInfo.stationNumber == 0)) {
            bl = true;
        }
        return bl;
    }
}

