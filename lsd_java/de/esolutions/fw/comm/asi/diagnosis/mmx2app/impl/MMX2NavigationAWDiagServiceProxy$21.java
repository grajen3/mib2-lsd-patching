/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$21
implements ISerializable {
    private final /* synthetic */ sSystemName val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$21(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sSystemName sSystemName2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sSystemName2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSystemNameSerializer.putOptionalsSystemName(iSerializer, this.val$data);
    }
}

