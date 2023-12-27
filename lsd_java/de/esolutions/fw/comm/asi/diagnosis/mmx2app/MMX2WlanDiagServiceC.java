/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;

public interface MMX2WlanDiagServiceC {
    default public void responseErrorWlan(sClientResponseError sClientResponseError2) {
    }

    default public void responseWlanProperties(sWlanProperties sWlanProperties2) {
    }

    default public void responseSetWlanHotSpotActive(long l) {
    }

    default public void responseWlanHotSpotActive(long l, boolean bl) {
    }

    default public void responseWlanConnectToAP(long l) {
    }
}

