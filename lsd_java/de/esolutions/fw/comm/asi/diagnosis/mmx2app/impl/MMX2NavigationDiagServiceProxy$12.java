/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$12
implements ISerializable {
    private final /* synthetic */ sApplicationSoftwareVersionNumber val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$12(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sApplicationSoftwareVersionNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, this.val$data);
    }
}

