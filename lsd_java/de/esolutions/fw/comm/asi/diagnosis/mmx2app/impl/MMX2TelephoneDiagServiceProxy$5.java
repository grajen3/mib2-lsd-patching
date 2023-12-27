/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sConnectedBtHandsetSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$5
implements ISerializable {
    private final /* synthetic */ sConnectedBtHandset val$btHandset;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$5(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sConnectedBtHandset sConnectedBtHandset2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$btHandset = sConnectedBtHandset2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sConnectedBtHandsetSerializer.putOptionalsConnectedBtHandset(iSerializer, this.val$btHandset);
    }
}

