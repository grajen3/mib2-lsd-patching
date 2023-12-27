/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import java.util.Comparator;

public final class AslStationSubChannelFeatureComparator
implements Comparator {
    public static final AslStationSubChannelFeatureComparator INSTANCE = new AslStationSubChannelFeatureComparator();

    private AslStationSubChannelFeatureComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2) {
            return 0;
        }
        boolean bl = ((AmFmStation)object).isHD();
        boolean bl2 = ((AmFmStation)object2).isHD();
        if (bl && !bl2) {
            return -1;
        }
        if (!bl && bl2) {
            return 1;
        }
        return 0;
    }
}

