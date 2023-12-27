/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.comparator.AslStationFrequencyComparator;
import de.vw.mib.asl.internal.radio.comparator.FmAlphabeticalComparator;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import java.util.Comparator;

public final class PtyComparator
implements Comparator {
    public static final PtyComparator INSTANCE = new PtyComparator();

    private PtyComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        if (null == object || null == object2) {
            return 0;
        }
        if (RadioCodingAdapter.isPiActivated() && AmfmRDSOption.get()) {
            String string;
            int n;
            AmFmStation amFmStation = (AmFmStation)object;
            AmFmStation amFmStation2 = (AmFmStation)object2;
            int n2 = amFmStation.getPtyCode();
            int n3 = amFmStation2.getPtyCode();
            int n4 = this.getPtyGroup(n2);
            if (n4 > (n = this.getPtyGroup(n3))) {
                return 1;
            }
            if (n4 < n) {
                return -1;
            }
            if (n2 > n3) {
                return 1;
            }
            if (n2 < n3) {
                return -1;
            }
            String string2 = amFmStation.getName();
            String string3 = amFmStation2.getName();
            String string4 = RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation.getPi(), amFmStation.getFrequency());
            if (string4 != null) {
                string2 = string4;
            }
            if ((string = RadioData.getAmfmDatabase().getFixedStationList().getName(amFmStation2.getPi(), amFmStation2.getFrequency())) != null) {
                string3 = string;
            }
            if (string2.length() > 0 && string3.length() > 0) {
                return FmAlphabeticalComparator.INSTANCE.compare(object, object2);
            }
            if (string2.length() > 0 && string3.length() <= 0) {
                return -1;
            }
            if (string2.length() <= 0 && string3.length() > 0) {
                return 1;
            }
            if (string2.length() <= 0 && string3.length() <= 0) {
                return FrequencyHDComparatorChain.INSTANCE.compare(object, object2);
            }
            return -1;
        }
        return AslStationFrequencyComparator.INSTANCE.compare(object, object2);
    }

    public int getPtyGroup(int n) {
        switch (n) {
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: {
                return 0;
            }
            case 1: 
            case 3: 
            case 16: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 17: 
            case 18: 
            case 20: 
            case 29: {
                return 3;
            }
            case 2: 
            case 6: 
            case 9: 
            case 19: 
            case 21: 
            case 22: 
            case 23: 
            case 30: 
            case 31: {
                return 4;
            }
        }
        return 5;
    }
}

