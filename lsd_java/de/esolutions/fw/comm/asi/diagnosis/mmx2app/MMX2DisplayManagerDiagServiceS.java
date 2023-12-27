/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;

public interface MMX2DisplayManagerDiagServiceS {
    default public void responseErrorDisplayManager(sClientResponseError sClientResponseError2, MMX2DisplayManagerDiagServiceReply mMX2DisplayManagerDiagServiceReply) {
    }

    default public void responseVideoInputState(sVideoInputState sVideoInputState2, MMX2DisplayManagerDiagServiceReply mMX2DisplayManagerDiagServiceReply) {
    }

    default public void responseTrunkOfferFBAS(sTrunkOfferFBAS sTrunkOfferFBAS2, MMX2DisplayManagerDiagServiceReply mMX2DisplayManagerDiagServiceReply) {
    }
}

