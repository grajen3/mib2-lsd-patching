/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.comparator.FmAlphabeticalComparator;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import java.util.Comparator;

public final class FmProgrammeServiceNameComparatorThreeGroups
implements Comparator {
    public static final FmProgrammeServiceNameComparatorThreeGroups INSTANCE = new FmProgrammeServiceNameComparatorThreeGroups();

    private FmProgrammeServiceNameComparatorThreeGroups() {
    }

    @Override
    public int compare(Object object, Object object2) {
        try {
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
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return -1;
        }
    }
}

