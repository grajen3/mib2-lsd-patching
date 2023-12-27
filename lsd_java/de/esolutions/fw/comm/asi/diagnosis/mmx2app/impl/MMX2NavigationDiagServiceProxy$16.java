/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$16
implements ISerializable {
    private final /* synthetic */ sSystemName val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$16(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sSystemName sSystemName2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sSystemName2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSystemNameSerializer.putOptionalsSystemName(iSerializer, this.val$data);
    }
}

