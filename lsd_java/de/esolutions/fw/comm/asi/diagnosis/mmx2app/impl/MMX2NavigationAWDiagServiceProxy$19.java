/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$19
implements ISerializable {
    private final /* synthetic */ sHardwareVersionNumber val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$19(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sHardwareVersionNumber sHardwareVersionNumber2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sHardwareVersionNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sHardwareVersionNumberSerializer.putOptionalsHardwareVersionNumber(iSerializer, this.val$data);
    }
}

