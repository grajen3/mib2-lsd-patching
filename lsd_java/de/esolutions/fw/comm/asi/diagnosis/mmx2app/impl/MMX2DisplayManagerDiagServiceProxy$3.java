/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl.sTrunkOfferFBASSerializer;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2DisplayManagerDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sTrunkOfferFBAS val$result;
    private final /* synthetic */ MMX2DisplayManagerDiagServiceProxy this$0;

    MMX2DisplayManagerDiagServiceProxy$3(MMX2DisplayManagerDiagServiceProxy mMX2DisplayManagerDiagServiceProxy, sTrunkOfferFBAS sTrunkOfferFBAS2) {
        this.this$0 = mMX2DisplayManagerDiagServiceProxy;
        this.val$result = sTrunkOfferFBAS2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTrunkOfferFBASSerializer.putOptionalsTrunkOfferFBAS(iSerializer, this.val$result);
    }
}

