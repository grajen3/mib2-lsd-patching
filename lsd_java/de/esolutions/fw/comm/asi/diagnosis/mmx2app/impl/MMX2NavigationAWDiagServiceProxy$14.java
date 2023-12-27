/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sInfraredBeaconStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sInfraredBeaconStateVICS;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$14
implements ISerializable {
    private final /* synthetic */ sInfraredBeaconStateVICS val$state;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$14(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sInfraredBeaconStateVICS sInfraredBeaconStateVICS2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$state = sInfraredBeaconStateVICS2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sInfraredBeaconStateVICSSerializer.putOptionalsInfraredBeaconStateVICS(iSerializer, this.val$state);
    }
}

