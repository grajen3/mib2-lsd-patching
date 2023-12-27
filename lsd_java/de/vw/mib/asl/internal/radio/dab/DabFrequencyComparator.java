/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import java.util.Comparator;
import org.dsi.ifc.radio.FrequencyInfo;

public class DabFrequencyComparator
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        FrequencyInfo frequencyInfo = (FrequencyInfo)object;
        FrequencyInfo frequencyInfo2 = (FrequencyInfo)object2;
        if (frequencyInfo.frequency < frequencyInfo2.frequency) {
            return -1;
        }
        if (frequencyInfo.frequency > frequencyInfo2.frequency) {
            return 1;
        }
        return 0;
    }
}

