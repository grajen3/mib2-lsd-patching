/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sHardwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$14
implements ISerializable {
    private final /* synthetic */ sHardwareVersionNumber val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$14(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sHardwareVersionNumber sHardwareVersionNumber2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sHardwareVersionNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sHardwareVersionNumberSerializer.putOptionalsHardwareVersionNumber(iSerializer, this.val$data);
    }
}

