/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$17
implements ISerializable {
    private final /* synthetic */ sApplicationSoftwareVersionNumber val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$17(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sApplicationSoftwareVersionNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, this.val$data);
    }
}

