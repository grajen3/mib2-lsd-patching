/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;

public interface MMX2SwdlDiagServiceS {
    default public void responseErrorSwdl(sClientResponseError sClientResponseError2, MMX2SwdlDiagServiceReply mMX2SwdlDiagServiceReply) {
    }

    default public void responseModuleVersionNumbers(sModuleVersionNumbers sModuleVersionNumbers2, MMX2SwdlDiagServiceReply mMX2SwdlDiagServiceReply) {
    }
}

