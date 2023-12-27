/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sTelephoneTemperatureSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$8
implements ISerializable {
    private final /* synthetic */ sTelephoneTemperature val$temperature;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$8(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sTelephoneTemperature sTelephoneTemperature2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$temperature = sTelephoneTemperature2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTelephoneTemperatureSerializer.putOptionalsTelephoneTemperature(iSerializer, this.val$temperature);
    }
}

