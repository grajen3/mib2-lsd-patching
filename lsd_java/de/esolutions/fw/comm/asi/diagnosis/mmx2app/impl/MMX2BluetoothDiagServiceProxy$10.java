/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$10
implements ISerializable {
    private final /* synthetic */ sRoutineResponse val$routineResponse;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$10(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sRoutineResponse sRoutineResponse2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$routineResponse = sRoutineResponse2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sRoutineResponseSerializer.putOptionalsRoutineResponse(iSerializer, this.val$routineResponse);
    }
}

