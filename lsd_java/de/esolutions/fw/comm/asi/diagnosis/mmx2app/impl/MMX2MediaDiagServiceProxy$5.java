/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.impl.sMediaRegionCodesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$5
implements ISerializable {
    private final /* synthetic */ sMediaRegionCodes val$regionCodes;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$5(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sMediaRegionCodes sMediaRegionCodes2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$regionCodes = sMediaRegionCodes2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sMediaRegionCodesSerializer.putOptionalsMediaRegionCodes(iSerializer, this.val$regionCodes);
    }
}

