/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$18
implements ISerializable {
    private final /* synthetic */ sHardwareNumber val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$18(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sHardwareNumber sHardwareNumber2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sHardwareNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sHardwareNumberSerializer.putOptionalsHardwareNumber(iSerializer, this.val$data);
    }
}

