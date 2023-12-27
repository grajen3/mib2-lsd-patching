/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.FecClientProxy;
import de.esolutions.fw.comm.asi.fec.impl.SFecStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class FecClientProxy$1
implements ISerializable {
    private final /* synthetic */ SFecState[] val$statevector;
    private final /* synthetic */ FecClientProxy this$0;

    FecClientProxy$1(FecClientProxy fecClientProxy, SFecState[] sFecStateArray) {
        this.this$0 = fecClientProxy;
        this.val$statevector = sFecStateArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SFecStateSerializer.putOptionalSFecStateVarArray(iSerializer, this.val$statevector);
    }
}

