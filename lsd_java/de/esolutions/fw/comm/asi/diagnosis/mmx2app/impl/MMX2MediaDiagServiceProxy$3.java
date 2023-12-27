/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaDBVersionSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sMediaDBVersion val$dbVersion;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$3(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sMediaDBVersion sMediaDBVersion2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$dbVersion = sMediaDBVersion2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sMediaDBVersionSerializer.putOptionalsMediaDBVersion(iSerializer, this.val$dbVersion);
    }
}

