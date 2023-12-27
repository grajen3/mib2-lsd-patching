/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import java.util.Comparator;
import org.dsi.ifc.sdars.StationInfo;

public final class ComparatorChannelNumber
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        if (object == null || object2 == null) {
            throw new ClassCastException();
        }
        StationInfo stationInfo = (StationInfo)object;
        StationInfo stationInfo2 = (StationInfo)object2;
        if (stationInfo.stationNumber > stationInfo2.stationNumber) {
            return 1;
        }
        if (stationInfo.stationNumber < stationInfo2.stationNumber) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return "ChannelComparatorNumber";
    }
}

