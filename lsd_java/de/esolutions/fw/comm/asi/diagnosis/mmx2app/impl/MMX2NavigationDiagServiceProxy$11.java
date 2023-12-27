/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sSparePartNumberSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2NavigationDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2NavigationDiagServiceProxy$11
implements ISerializable {
    private final /* synthetic */ sSparePartNumber val$data;
    private final /* synthetic */ MMX2NavigationDiagServiceProxy this$0;

    MMX2NavigationDiagServiceProxy$11(MMX2NavigationDiagServiceProxy mMX2NavigationDiagServiceProxy, sSparePartNumber sSparePartNumber2) {
        this.this$0 = mMX2NavigationDiagServiceProxy;
        this.val$data = sSparePartNumber2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sSparePartNumberSerializer.putOptionalsSparePartNumber(iSerializer, this.val$data);
    }
}

