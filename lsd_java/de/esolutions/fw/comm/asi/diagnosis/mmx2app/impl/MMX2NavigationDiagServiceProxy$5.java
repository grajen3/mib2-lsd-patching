/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sGPSNoSatelliteSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sGPSNoSatellite;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$5
implements ISerializable {
    private final /* synthetic */ sGPSNoSatellite val$lastOccurance;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$5(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sGPSNoSatellite sGPSNoSatellite2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$lastOccurance = sGPSNoSatellite2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sGPSNoSatelliteSerializer.putOptionalsGPSNoSatellite(iSerializer, this.val$lastOccurance);
    }
}

