/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sActiveNavDBSerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sActiveNavDB;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$4
implements ISerializable {
    private final /* synthetic */ sActiveNavDB val$activeNavDB;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$4(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sActiveNavDB sActiveNavDB2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$activeNavDB = sActiveNavDB2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sActiveNavDBSerializer.putOptionalsActiveNavDB(iSerializer, this.val$activeNavDB);
    }
}

