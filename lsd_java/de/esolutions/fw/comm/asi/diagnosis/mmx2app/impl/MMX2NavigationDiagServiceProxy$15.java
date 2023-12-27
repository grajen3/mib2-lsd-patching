/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSerialNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$15
implements ISerializable {
    private final /* synthetic */ sSerialNumber val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$15(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sSerialNumber sSerialNumber2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sSerialNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSerialNumberSerializer.putOptionalsSerialNumber(iSerializer, this.val$data);
    }
}

