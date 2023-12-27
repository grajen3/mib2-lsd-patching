/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSystemNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$12
implements ISerializable {
    private final /* synthetic */ sSystemName val$data;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$12(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sSystemName sSystemName2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$data = sSystemName2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSystemNameSerializer.putOptionalsSystemName(iSerializer, this.val$data);
    }
}

