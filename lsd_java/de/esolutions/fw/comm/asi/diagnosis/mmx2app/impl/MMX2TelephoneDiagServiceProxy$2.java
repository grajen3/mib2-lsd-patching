/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sSimStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sSimState val$simState;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$2(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sSimState sSimState2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$simState = sSimState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSimStateSerializer.putOptionalsSimState(iSerializer, this.val$simState);
    }
}

