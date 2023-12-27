/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sGPSOffroadSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSOffroad;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$6
implements ISerializable {
    private final /* synthetic */ sGPSOffroad val$lastOccurance;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$6(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sGPSOffroad sGPSOffroad2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$lastOccurance = sGPSOffroad2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sGPSOffroadSerializer.putOptionalsGPSOffroad(iSerializer, this.val$lastOccurance);
    }
}

