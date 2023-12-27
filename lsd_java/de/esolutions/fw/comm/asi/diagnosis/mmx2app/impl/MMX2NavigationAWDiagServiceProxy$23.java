/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$23
implements ISerializable {
    private final /* synthetic */ sRoutineResponse val$routineResponse;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$23(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sRoutineResponse sRoutineResponse2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$routineResponse = sRoutineResponse2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, this.val$routineResponse);
    }
}

