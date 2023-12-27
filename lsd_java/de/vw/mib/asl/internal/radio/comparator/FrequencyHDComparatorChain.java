/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.comparator.AslStationFrequencyComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationSubChannelComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationSubChannelFeatureComparator;
import java.util.Comparator;

public final class FrequencyHDComparatorChain
implements Comparator {
    public static final FrequencyHDComparatorChain INSTANCE = new FrequencyHDComparatorChain();

    private FrequencyHDComparatorChain() {
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2) {
            return 0;
        }
        int n = AslStationFrequencyComparator.INSTANCE.compare(object, object2);
        if (n != 0) {
            return n;
        }
        int n2 = AslStationSubChannelFeatureComparator.INSTANCE.compare(object, object2);
        if (n2 != 0) {
            return n2;
        }
        if (!((AmFmStation)object).isHD() && !((AmFmStation)object2).isHD()) {
            return 0;
        }
        return AslStationSubChannelComparator.INSTANCE.compare(object, object2);
    }
}

