/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;

public interface MMX2AppDtcTestServiceC {
    default public void registerForDiagnosis(int n, long[] lArray) {
    }

    default public void deregisterForDiagnosis() {
    }

    default public void testStatus(sTestStatus sTestStatus2) {
    }
}

