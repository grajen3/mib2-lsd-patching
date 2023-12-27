/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;

public interface MMX2DisplayManagerDiagServiceC {
    default public void responseErrorDisplayManager(sClientResponseError sClientResponseError2) {
    }

    default public void responseVideoInputState(sVideoInputState sVideoInputState2) {
    }

    default public void responseTrunkOfferFBAS(sTrunkOfferFBAS sTrunkOfferFBAS2) {
    }
}

