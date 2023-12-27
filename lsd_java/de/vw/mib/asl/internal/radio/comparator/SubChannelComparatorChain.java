/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.comparator.AslStationSubChannelComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationSubChannelFeatureComparator;
import java.util.Comparator;

public final class SubChannelComparatorChain
implements Comparator {
    public static final SubChannelComparatorChain INSTANCE = new SubChannelComparatorChain();

    private SubChannelComparatorChain() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = AslStationSubChannelFeatureComparator.INSTANCE.compare(object, object2);
        if (n != 0) {
            return n;
        }
        if (((AmFmStation)object).isHD() && ((AmFmStation)object2).isHD()) {
            return AslStationSubChannelComparator.INSTANCE.compare(object, object2);
        }
        return 0;
    }
}

