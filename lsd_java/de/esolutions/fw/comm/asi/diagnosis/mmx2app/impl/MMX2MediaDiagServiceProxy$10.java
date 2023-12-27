/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sApplicationSoftwareVersionNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$10
implements ISerializable {
    private final /* synthetic */ sApplicationSoftwareVersionNumber val$data;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$10(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$data = sApplicationSoftwareVersionNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sApplicationSoftwareVersionNumberSerializer.putOptionalsApplicationSoftwareVersionNumber(iSerializer, this.val$data);
    }
}

