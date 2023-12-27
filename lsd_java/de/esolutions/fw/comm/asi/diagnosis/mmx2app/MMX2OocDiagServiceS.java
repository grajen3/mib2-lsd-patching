/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;

public interface MMX2OocDiagServiceS {
    default public void responseErrorOoc(sClientResponseError sClientResponseError2, MMX2OocDiagServiceReply mMX2OocDiagServiceReply) {
    }

    default public void responseTemperatureMMX(sTemperatureMMX sTemperatureMMX2, MMX2OocDiagServiceReply mMX2OocDiagServiceReply) {
    }

    default public void responseDeleteMemory(sRoutineResponse sRoutineResponse2, MMX2OocDiagServiceReply mMX2OocDiagServiceReply) {
    }
}

