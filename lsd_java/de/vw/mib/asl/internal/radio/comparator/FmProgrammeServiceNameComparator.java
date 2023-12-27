/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.comparator.FmAlphabeticalComparator;
import de.vw.mib.asl.internal.radio.comparator.FmPiFrequencyHdComparatorChain;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import java.util.Comparator;

public final class FmProgrammeServiceNameComparator
implements Comparator {
    public static final FmProgrammeServiceNameComparator INSTANCE = new FmProgrammeServiceNameComparator();

    private FmProgrammeServiceNameComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        try {
            if (null == object || null == object2) {
                return 0;
            }
            String string = ((AmFmStation)object).getName();
            String string2 = ((AmFmStation)object2).getName();
            boolean bl = ((AmFmStation)object).isScrollingPS();
            boolean bl2 = ((AmFmStation)object2).isScrollingPS();
            if (string.length() > 0 && string2.length() > 0) {
                if (!bl && !bl2) {
                    return FmAlphabeticalComparator.INSTANCE.compare(object, object2);
                }
                if (!bl && bl2) {
                    return -1;
                }
                if (bl && !bl2) {
                    return 1;
                }
                if (bl && bl2) {
                    return FmPiFrequencyHdComparatorChain.INSTANCE.compare(object, object2);
                }
            }
            if (string.length() > 0 && string2.length() <= 0) {
                return -1;
            }
            if (string.length() <= 0 && string2.length() > 0) {
                return 1;
            }
            if (string.length() <= 0 && string2.length() <= 0) {
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

