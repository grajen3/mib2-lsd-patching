/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy;
import de.esolutions.fw.comm.asi.fec.impl.SFecStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecAppMMXReplyProxy$2
implements ISerializable {
    private final /* synthetic */ SFecState[] val$statevector;
    private final /* synthetic */ FecAppMMXReplyProxy this$0;

    FecAppMMXReplyProxy$2(FecAppMMXReplyProxy fecAppMMXReplyProxy, SFecState[] sFecStateArray) {
        this.this$0 = fecAppMMXReplyProxy;
        this.val$statevector = sFecStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SFecStateSerializer.putOptionalSFecStateVarArray(iSerializer, this.val$statevector);
    }
}

