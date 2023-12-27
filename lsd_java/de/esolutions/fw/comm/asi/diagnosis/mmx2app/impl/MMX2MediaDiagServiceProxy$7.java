/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sUsbOvercurrentSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$7
implements ISerializable {
    private final /* synthetic */ sUsbOvercurrent val$overcurrent;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$7(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sUsbOvercurrent sUsbOvercurrent2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$overcurrent = sUsbOvercurrent2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sUsbOvercurrentSerializer.putOptionalsUsbOvercurrent(iSerializer, this.val$overcurrent);
    }
}

