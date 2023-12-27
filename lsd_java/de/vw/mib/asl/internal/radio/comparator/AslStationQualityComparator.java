/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import java.util.Comparator;

public final class AslStationQualityComparator
implements Comparator {
    public static final AslStationQualityComparator INSTANCE = new AslStationQualityComparator();

    private AslStationQualityComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        AmFmStation amFmStation = (AmFmStation)object;
        AmFmStation amFmStation2 = (AmFmStation)object2;
        if (amFmStation.getReceptionQuality() > amFmStation2.getReceptionQuality()) {
            return -1;
        }
        if (amFmStation.getReceptionQuality() < amFmStation2.getReceptionQuality()) {
            return 1;
        }
        return 0;
    }
}

