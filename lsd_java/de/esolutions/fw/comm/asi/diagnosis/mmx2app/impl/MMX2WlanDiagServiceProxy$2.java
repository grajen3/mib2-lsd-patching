/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.wlan.impl.sWlanPropertiesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2WlanDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sWlanProperties val$properties;
    private final /* synthetic */ MMX2WlanDiagServiceProxy this$0;

    MMX2WlanDiagServiceProxy$2(MMX2WlanDiagServiceProxy mMX2WlanDiagServiceProxy, sWlanProperties sWlanProperties2) {
        this.this$0 = mMX2WlanDiagServiceProxy;
        this.val$properties = sWlanProperties2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sWlanPropertiesSerializer.putOptionalsWlanProperties(iSerializer, this.val$properties);
    }
}

