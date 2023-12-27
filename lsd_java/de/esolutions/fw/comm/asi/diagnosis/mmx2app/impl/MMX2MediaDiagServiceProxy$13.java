/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sDTCPStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$13
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ sDTCPState[] val$dtcpStates;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$13(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, long l, sDTCPState[] sDTCPStateArray) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$msg_id = l;
        this.val$dtcpStates = sDTCPStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        sDTCPStateSerializer.putOptionalsDTCPStateVarArray(iSerializer, this.val$dtcpStates);
    }
}

