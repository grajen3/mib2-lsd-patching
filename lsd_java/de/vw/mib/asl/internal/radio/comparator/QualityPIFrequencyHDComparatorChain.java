/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.comparator.AslStationQualityComparator;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import java.util.Comparator;

public final class QualityPIFrequencyHDComparatorChain
implements Comparator {
    public static final QualityPIFrequencyHDComparatorChain INSTANCE = new QualityPIFrequencyHDComparatorChain();

    private QualityPIFrequencyHDComparatorChain() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n = AslStationQualityComparator.INSTANCE.compare(object, object2);
        if (n != 0) {
            return n;
        }
        return FmPiFrequencyHdComparatorChain.INSTANCE.compare(object, object2);
    }
}

