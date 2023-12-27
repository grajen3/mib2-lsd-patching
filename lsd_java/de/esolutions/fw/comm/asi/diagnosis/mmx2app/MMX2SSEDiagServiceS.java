/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceReply;

public interface MMX2SSEDiagServiceS {
    default public void responseErrorSSE(sClientResponseError sClientResponseError2, MMX2SSEDiagServiceReply mMX2SSEDiagServiceReply) {
    }

    default public void responseClippingCounterMic1(long l, long l2, MMX2SSEDiagServiceReply mMX2SSEDiagServiceReply) {
    }
}

