/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCalibrationStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCalibrationState;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$7
implements ISerializable {
    private final /* synthetic */ sNavCalibrationState val$calibrationState;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$7(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sNavCalibrationState sNavCalibrationState2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$calibrationState = sNavCalibrationState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNavCalibrationStateSerializer.putOptionalsNavCalibrationState(iSerializer, this.val$calibrationState);
    }
}

