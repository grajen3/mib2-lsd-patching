/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sActiveMediaSourceStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$4
implements ISerializable {
    private final /* synthetic */ sActiveMediaSourceState val$mediaSourceState;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$4(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sActiveMediaSourceState sActiveMediaSourceState2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$mediaSourceState = sActiveMediaSourceState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sActiveMediaSourceStateSerializer.putOptionalsActiveMediaSourceState(iSerializer, this.val$mediaSourceState);
    }
}

