/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$20
implements ISerializable {
    private final /* synthetic */ sSerialNumber val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$20(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sSerialNumber sSerialNumber2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sSerialNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, this.val$data);
    }
}

