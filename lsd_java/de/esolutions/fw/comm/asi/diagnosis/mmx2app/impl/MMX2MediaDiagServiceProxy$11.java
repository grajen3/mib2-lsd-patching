/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$11
implements ISerializable {
    private final /* synthetic */ sSerialNumber val$data;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$11(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sSerialNumber sSerialNumber2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$data = sSerialNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, this.val$data);
    }
}

