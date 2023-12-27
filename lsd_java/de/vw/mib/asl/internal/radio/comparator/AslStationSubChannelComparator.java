/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import java.util.Comparator;

public final class AslStationSubChannelComparator
implements Comparator {
    public static final AslStationSubChannelComparator INSTANCE = new AslStationSubChannelComparator();

    private AslStationSubChannelComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        if (null == object || null == object2) {
            return 0;
        }
        if (!((AmFmStation)object).isHD() || !((AmFmStation)object2).isHD()) {
            throw new IllegalArgumentException("expected AslStations with HD flag=true");
        }
        int n2 = ((AmFmStation)object).getSubChannel();
        if (n2 > (n = ((AmFmStation)object2).getSubChannel())) {
            return 1;
        }
        if (n2 < n) {
            return -1;
        }
        return 0;
    }
}

