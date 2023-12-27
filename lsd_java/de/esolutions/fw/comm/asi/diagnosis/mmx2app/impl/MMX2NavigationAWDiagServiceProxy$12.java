/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sAntennaStateVICSSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateVICS;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$12
implements ISerializable {
    private final /* synthetic */ sAntennaStateVICS val$state;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$12(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sAntennaStateVICS sAntennaStateVICS2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$state = sAntennaStateVICS2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sAntennaStateVICSSerializer.putOptionalsAntennaStateVICS(iSerializer, this.val$state);
    }
}

