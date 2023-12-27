/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceReply;

public interface MMX2AppDtcTestServiceS {
    default public void registerForDiagnosis(int n, long[] lArray, MMX2AppDtcTestServiceReply mMX2AppDtcTestServiceReply) {
    }

    default public void deregisterForDiagnosis(MMX2AppDtcTestServiceReply mMX2AppDtcTestServiceReply) {
    }

    default public void testStatus(sTestStatus sTestStatus2, MMX2AppDtcTestServiceReply mMX2AppDtcTestServiceReply) {
    }
}

