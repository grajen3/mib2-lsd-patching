/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sNumberHandsetsHUCsSerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$6
implements ISerializable {
    private final /* synthetic */ sNumberHandsetsHUCs val$numberHandsetsHUCs;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$6(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sNumberHandsetsHUCs sNumberHandsetsHUCs2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$numberHandsetsHUCs = sNumberHandsetsHUCs2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNumberHandsetsHUCsSerializer.putOptionalsNumberHandsetsHUCs(iSerializer, this.val$numberHandsetsHUCs);
    }
}

