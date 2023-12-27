/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sVersionsNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sVersionsNavDB val$versions;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$3(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sVersionsNavDB sVersionsNavDB2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$versions = sVersionsNavDB2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sVersionsNavDBSerializer.putOptionalsVersionsNavDB(iSerializer, this.val$versions);
    }
}

