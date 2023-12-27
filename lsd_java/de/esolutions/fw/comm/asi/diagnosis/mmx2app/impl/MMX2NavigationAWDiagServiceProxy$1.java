/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$1
implements ISerializable {
    private final /* synthetic */ sClientResponseError val$responseError;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$1(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sClientResponseError sClientResponseError2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$responseError = sClientResponseError2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, this.val$responseError);
    }
}

