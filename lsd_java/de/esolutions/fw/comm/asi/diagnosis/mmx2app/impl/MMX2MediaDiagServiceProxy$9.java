/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceProxy$9
implements ISerializable {
    private final /* synthetic */ sSparePartNumber val$data;
    private final /* synthetic */ MMX2MediaDiagServiceProxy this$0;

    MMX2MediaDiagServiceProxy$9(MMX2MediaDiagServiceProxy mMX2MediaDiagServiceProxy, sSparePartNumber sSparePartNumber2) {
        this.this$0 = mMX2MediaDiagServiceProxy;
        this.val$data = sSparePartNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, this.val$data);
    }
}

