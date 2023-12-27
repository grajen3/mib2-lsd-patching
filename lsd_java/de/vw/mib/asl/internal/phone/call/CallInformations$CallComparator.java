/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import java.util.Comparator;

class CallInformations$CallComparator
implements Comparator {
    static final CallInformations$CallComparator INSTANCE = new CallInformations$CallComparator();

    private CallInformations$CallComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        try {
            int n = ((PhoneCallInformationCollector)object).callInformation.telCallStartingTime & 0xFFFFFF7F;
            int n2 = ((PhoneCallInformationCollector)object2).callInformation.telCallStartingTime & 0xFFFFFF7F;
            return n - n2;
        }
        catch (ClassCastException classCastException) {
            return 0;
        }
    }
}

