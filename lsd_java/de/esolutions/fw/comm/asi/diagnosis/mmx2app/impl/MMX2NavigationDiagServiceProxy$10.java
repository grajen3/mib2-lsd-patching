/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$10
implements ISerializable {
    private final /* synthetic */ sRoutineResponse val$routineResponse;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$10(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sRoutineResponse sRoutineResponse2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$routineResponse = sRoutineResponse2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, this.val$routineResponse);
    }
}

