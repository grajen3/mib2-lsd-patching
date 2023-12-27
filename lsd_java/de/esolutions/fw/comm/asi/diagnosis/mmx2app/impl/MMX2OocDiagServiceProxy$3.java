/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2OocDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sRoutineResponse val$routineResponse;
    private final /* synthetic */ MMX2OocDiagServiceProxy this$0;

    MMX2OocDiagServiceProxy$3(MMX2OocDiagServiceProxy mMX2OocDiagServiceProxy, sRoutineResponse sRoutineResponse2) {
        this.this$0 = mMX2OocDiagServiceProxy;
        this.val$routineResponse = sRoutineResponse2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, this.val$routineResponse);
    }
}

