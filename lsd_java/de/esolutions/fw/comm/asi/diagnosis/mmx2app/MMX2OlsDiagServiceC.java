/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;

public interface MMX2OlsDiagServiceC {
    default public void responseErrorOls(sClientResponseError sClientResponseError2) {
    }

    default public void responseConnectionState(sConnectionState sConnectionState2) {
    }

    default public void responseActivationState(sActivationState sActivationState2) {
    }
}

