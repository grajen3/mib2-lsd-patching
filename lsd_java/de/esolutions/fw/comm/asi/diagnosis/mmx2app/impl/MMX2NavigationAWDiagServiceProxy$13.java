/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sRadioBeaconStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sRadioBeaconStateVICS;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$13
implements ISerializable {
    private final /* synthetic */ sRadioBeaconStateVICS val$state;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$13(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sRadioBeaconStateVICS sRadioBeaconStateVICS2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$state = sRadioBeaconStateVICS2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sRadioBeaconStateVICSSerializer.putOptionalsRadioBeaconStateVICS(iSerializer, this.val$state);
    }
}

