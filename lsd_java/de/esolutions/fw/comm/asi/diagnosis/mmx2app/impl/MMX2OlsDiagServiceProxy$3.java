/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.ols.impl.sActivationStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2OlsDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sActivationState val$state;
    private final /* synthetic */ MMX2OlsDiagServiceProxy this$0;

    MMX2OlsDiagServiceProxy$3(MMX2OlsDiagServiceProxy mMX2OlsDiagServiceProxy, sActivationState sActivationState2) {
        this.this$0 = mMX2OlsDiagServiceProxy;
        this.val$state = sActivationState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sActivationStateSerializer.putOptionalsActivationState(iSerializer, this.val$state);
    }
}

