/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import java.util.Comparator;
import org.dsi.ifc.sdars.StationInfo;

public final class ComparatorChannelFulllabel
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        if (object == null || object2 == null) {
            throw new ClassCastException();
        }
        StationInfo stationInfo = (StationInfo)object;
        StationInfo stationInfo2 = (StationInfo)object2;
        return stationInfo.fullLabel.compareToIgnoreCase(stationInfo2.fullLabel);
    }

    public String toString() {
        return "ChannelComparatorFulllabel";
    }
}

