/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$13
implements ISerializable {
    private final /* synthetic */ sHardwareNumber val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$13(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sHardwareNumber sHardwareNumber2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sHardwareNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sHardwareNumberSerializer.putOptionalsHardwareNumber(iSerializer, this.val$data);
    }
}

