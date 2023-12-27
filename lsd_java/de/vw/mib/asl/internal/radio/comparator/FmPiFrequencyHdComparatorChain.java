/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.comparator.AslStationFrequencyComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationPIComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationPIFeatureComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationSubChannelComparator;
import de.vw.mib.asl.internal.radio.comparator.AslStationSubChannelFeatureComparator;
import java.util.Comparator;

public final class FmPiFrequencyHdComparatorChain
implements Comparator {
    public static final FmPiFrequencyHdComparatorChain INSTANCE = new FmPiFrequencyHdComparatorChain();

    private FmPiFrequencyHdComparatorChain() {
    }

    @Override
    public int compare(Object object, Object object2) {
        int n;
        int n2;
        if (null == object || null == object2) {
            return 0;
        }
        if (RadioCodingAdapter.isPiActivated() && AmfmRDSOption.get()) {
            int n3;
            n2 = AslStationPIFeatureComparator.INSTANCE.compare(object, object2);
            if (n2 != 0) {
                return n2;
            }
            n = ProgramIdentification.hasValidPI((AmFmStation)object) ? 1 : 0;
            boolean bl = ProgramIdentification.hasValidPI((AmFmStation)object2);
            if (n != 0 && bl && (n3 = AslStationPIComparator.INSTANCE.compare(object, object2)) != 0) {
                return n3;
            }
        }
        if ((n2 = AslStationFrequencyComparator.INSTANCE.compare(object, object2)) != 0) {
            return n2;
        }
        n = AslStationSubChannelFeatureComparator.INSTANCE.compare(object, object2);
        if (n != 0) {
            return n;
        }
        if (!((AmFmStation)object).isHD() && !((AmFmStation)object2).isHD()) {
            return 0;
        }
        return AslStationSubChannelComparator.INSTANCE.compare(object, object2);
    }
}

