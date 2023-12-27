/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationAWDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationAWDiagServiceProxy$16
implements ISerializable {
    private final /* synthetic */ sSparePartNumber val$data;
    private final /* synthetic */ MMX2NavigationAWDiagServiceProxy this$0;

    MMX2NavigationAWDiagServiceProxy$16(MMX2NavigationAWDiagServiceProxy mMX2NavigationAWDiagServiceProxy, sSparePartNumber sSparePartNumber2) {
        this.this$0 = mMX2NavigationAWDiagServiceProxy;
        this.val$data = sSparePartNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, this.val$data);
    }
}

