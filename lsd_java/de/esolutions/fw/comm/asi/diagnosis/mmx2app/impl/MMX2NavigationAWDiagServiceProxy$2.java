/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.impl.sSubsystemStatesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigationAW.sSubsystemStates;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sSubsystemStates val$states;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$2(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sSubsystemStates sSubsystemStates2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$states = sSubsystemStates2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSubsystemStatesSerializer.putOptionalsSubsystemStates(iSerializer, this.val$states);
    }
}

