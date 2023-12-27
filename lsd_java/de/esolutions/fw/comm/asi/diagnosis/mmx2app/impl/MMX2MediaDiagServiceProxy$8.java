/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sPmlStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$8
implements ISerializable {
    private final /* synthetic */ sPmlState val$state;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$8(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sPmlState sPmlState2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$state = sPmlState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sPmlStateSerializer.putOptionalsPmlState(iSerializer, this.val$state);
    }
}

