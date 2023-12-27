/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl.sVideoInputStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2DisplayManagerDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sVideoInputState val$state;
    private final /* synthetic */ MMX2DisplayManagerDiagServiceProxy this$0;

    MMX2DisplayManagerDiagServiceProxy$2(MMX2DisplayManagerDiagServiceProxy mMX2DisplayManagerDiagServiceProxy, sVideoInputState sVideoInputState2) {
        this.this$0 = mMX2DisplayManagerDiagServiceProxy;
        this.val$state = sVideoInputState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sVideoInputStateSerializer.putOptionalsVideoInputState(iSerializer, this.val$state);
    }
}

