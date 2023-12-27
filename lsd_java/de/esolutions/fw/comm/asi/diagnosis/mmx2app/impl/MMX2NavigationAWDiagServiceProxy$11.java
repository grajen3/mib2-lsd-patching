/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sAntennaStateDSRCSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sAntennaStateDSRC;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$11
implements ISerializable {
    private final /* synthetic */ sAntennaStateDSRC val$state;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$11(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sAntennaStateDSRC sAntennaStateDSRC2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$state = sAntennaStateDSRC2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sAntennaStateDSRCSerializer.putOptionalsAntennaStateDSRC(iSerializer, this.val$state);
    }
}

