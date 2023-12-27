/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$9
implements ISerializable {
    private final /* synthetic */ sRoutineResponse val$routineResponse;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$9(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sRoutineResponse sRoutineResponse2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$routineResponse = sRoutineResponse2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, this.val$routineResponse);
    }
}

