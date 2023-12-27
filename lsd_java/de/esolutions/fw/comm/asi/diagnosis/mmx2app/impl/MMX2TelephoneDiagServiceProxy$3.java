/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.telephone.impl.sNadIMEISerializer;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sNadIMEI val$nadIMEI;
    private final /* synthetic */ MMX2TelephoneDiagServiceProxy this$0;

    MMX2TelephoneDiagServiceProxy$3(MMX2TelephoneDiagServiceProxy mMX2TelephoneDiagServiceProxy, sNadIMEI sNadIMEI2) {
        this.this$0 = mMX2TelephoneDiagServiceProxy;
        this.val$nadIMEI = sNadIMEI2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sNadIMEISerializer.putOptionalsNadIMEI(iSerializer, this.val$nadIMEI);
    }
}

