/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2SwdlDiagServiceProxy;
import de.esolutions.fw.comm.asi.diagnosis.swdl.impl.sModuleVersionNumbersSerializer;
import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2SwdlDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sModuleVersionNumbers val$versions;
    private final /* synthetic */ MMX2SwdlDiagServiceProxy this$0;

    MMX2SwdlDiagServiceProxy$2(MMX2SwdlDiagServiceProxy mMX2SwdlDiagServiceProxy, sModuleVersionNumbers sModuleVersionNumbers2) {
        this.this$0 = mMX2SwdlDiagServiceProxy;
        this.val$versions = sModuleVersionNumbers2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sModuleVersionNumbersSerializer.putOptionalsModuleVersionNumbers(iSerializer, this.val$versions);
    }
}

