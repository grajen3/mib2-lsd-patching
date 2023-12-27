/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;

public interface MMX2WlanDiagServiceS {
    default public void responseErrorWlan(sClientResponseError sClientResponseError2, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
    }

    default public void responseWlanProperties(sWlanProperties sWlanProperties2, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
    }

    default public void responseSetWlanHotSpotActive(long l, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
    }

    default public void responseWlanHotSpotActive(long l, boolean bl, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
    }

    default public void responseWlanConnectToAP(long l, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
    }
}

