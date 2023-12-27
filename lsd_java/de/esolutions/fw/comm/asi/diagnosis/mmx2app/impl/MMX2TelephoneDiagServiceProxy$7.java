/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneNetworkStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$7
implements ISerializable {
    private final /* synthetic */ sTelephoneNetworkState val$networkState;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$7(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sTelephoneNetworkState sTelephoneNetworkState2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$networkState = sTelephoneNetworkState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTelephoneNetworkStateSerializer.putOptionalsTelephoneNetworkState(iSerializer, this.val$networkState);
    }
}

