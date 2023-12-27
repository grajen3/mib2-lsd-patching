/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;

public interface MMX2OocDiagServiceC {
    default public void responseErrorOoc(sClientResponseError sClientResponseError2) {
    }

    default public void responseTemperatureMMX(sTemperatureMMX sTemperatureMMX2) {
    }

    default public void responseDeleteMemory(sRoutineResponse sRoutineResponse2) {
    }
}

