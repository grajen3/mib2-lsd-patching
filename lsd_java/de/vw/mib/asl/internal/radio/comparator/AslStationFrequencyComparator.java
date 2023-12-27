/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import java.util.Comparator;

public final class AslStationFrequencyComparator
implements Comparator {
    public static final AslStationFrequencyComparator INSTANCE = new AslStationFrequencyComparator();

    private AslStationFrequencyComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        if (null == object || null == object2) {
            return 0;
        }
        int n2 = ((AmFmStation)object).getFrequency();
        if (n2 > (n = ((AmFmStation)object2).getFrequency())) {
            return 1;
        }
        if (n2 < n) {
            return -1;
        }
        return 0;
    }
}

