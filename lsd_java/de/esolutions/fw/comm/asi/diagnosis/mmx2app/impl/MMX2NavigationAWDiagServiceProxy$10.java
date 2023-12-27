/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sUnitStateDSRCSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sUnitStateDSRC;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$10
implements ISerializable {
    private final /* synthetic */ sUnitStateDSRC val$state;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$10(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sUnitStateDSRC sUnitStateDSRC2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$state = sUnitStateDSRC2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sUnitStateDSRCSerializer.putOptionalsUnitStateDSRC(iSerializer, this.val$state);
    }
}

