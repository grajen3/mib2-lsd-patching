/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSubsystemStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sSubsystemState val$state;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$2(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sSubsystemState sSubsystemState2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$state = sSubsystemState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSubsystemStateSerializer.putOptionalsSubsystemState(iSerializer, this.val$state);
    }
}

