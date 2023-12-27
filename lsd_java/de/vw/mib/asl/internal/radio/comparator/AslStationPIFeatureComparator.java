/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import java.util.Comparator;

public final class AslStationPIFeatureComparator
implements Comparator {
    public static final AslStationPIFeatureComparator INSTANCE = new AslStationPIFeatureComparator();

    private AslStationPIFeatureComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        boolean bl = ProgramIdentification.hasValidPI((AmFmStation)object);
        boolean bl2 = ProgramIdentification.hasValidPI((AmFmStation)object2);
        if (bl && !bl2) {
            return -1;
        }
        if (!bl && bl2) {
            return 1;
        }
        return 0;
    }
}

