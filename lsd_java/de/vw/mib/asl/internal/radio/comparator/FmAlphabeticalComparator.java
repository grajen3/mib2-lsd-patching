/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import java.util.Comparator;

public final class FmAlphabeticalComparator
implements Comparator {
    public static final FmAlphabeticalComparator INSTANCE = new FmAlphabeticalComparator();

    private FmAlphabeticalComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        String string;
        if (null == object || null == object2) {
            return 0;
        }
        String string2 = ((AmFmStation)object).getName();
        String string3 = ((AmFmStation)object2).getName();
        String string4 = RadioData.getAmfmDatabase().getFixedStationList().getName(((AmFmStation)object).getPi(), ((AmFmStation)object).getFrequency());
        if (string4 != null) {
            string2 = string4;
        }
        if ((string = RadioData.getAmfmDatabase().getFixedStationList().getName(((AmFmStation)object2).getPi(), ((AmFmStation)object2).getFrequency())) != null) {
            string3 = string;
        }
        if (0 < (n = string2.compareToIgnoreCase(string3))) {
            return 1;
        }
        if (0 > n) {
            return -1;
        }
        return FmPiFrequencyHdComparatorChain.INSTANCE.compare(object, object2);
    }
}

