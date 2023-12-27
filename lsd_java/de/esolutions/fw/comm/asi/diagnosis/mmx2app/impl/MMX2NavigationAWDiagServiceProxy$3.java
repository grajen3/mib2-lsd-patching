/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sVersionsNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sVersionsNavDB;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sVersionsNavDB val$versions;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$3(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sVersionsNavDB sVersionsNavDB2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$versions = sVersionsNavDB2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sVersionsNavDBSerializer.putOptionalsVersionsNavDB(iSerializer, this.val$versions);
    }
}

