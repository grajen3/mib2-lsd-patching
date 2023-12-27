/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneAntennaStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$4
implements ISerializable {
    private final /* synthetic */ sTelephoneAntennaState val$antennaState;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$4(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sTelephoneAntennaState sTelephoneAntennaState2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$antennaState = sTelephoneAntennaState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTelephoneAntennaStateSerializer.putOptionalsTelephoneAntennaState(iSerializer, this.val$antennaState);
    }
}

