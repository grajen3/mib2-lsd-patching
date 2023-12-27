/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SSEDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2SSEDiagServiceProxy$1
implements ISerializable {
    private final /* synthetic */ sClientResponseError val$responseError;
    private final /* synthetic */ MMX2SSEDiagServiceProxy this$0;

    MMX2SSEDiagServiceProxy$1(MMX2SSEDiagServiceProxy mMX2SSEDiagServiceProxy, sClientResponseError sClientResponseError2) {
        this.this$0 = mMX2SSEDiagServiceProxy;
        this.val$responseError = sClientResponseError2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, this.val$responseError);
    }
}

