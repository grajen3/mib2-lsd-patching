/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.ols.impl.sConnectionStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2OlsDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sConnectionState val$state;
    private final /* synthetic */ MMX2OlsDiagServiceProxy this$0;

    MMX2OlsDiagServiceProxy$2(MMX2OlsDiagServiceProxy mMX2OlsDiagServiceProxy, sConnectionState sConnectionState2) {
        this.this$0 = mMX2OlsDiagServiceProxy;
        this.val$state = sConnectionState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sConnectionStateSerializer.putOptionalsConnectionState(iSerializer, this.val$state);
    }
}

