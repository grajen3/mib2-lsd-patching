/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.dsi.telephone.impl.CFRequestDataSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.DSITelephoneProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.CFRequestData;

class DSITelephoneProxy$2
implements ISerializable {
    private final /* synthetic */ CFRequestData[] val$telCFRequestData;
    private final /* synthetic */ DSITelephoneProxy this$0;

    DSITelephoneProxy$2(DSITelephoneProxy dSITelephoneProxy, CFRequestData[] cFRequestDataArray) {
        this.this$0 = dSITelephoneProxy;
        this.val$telCFRequestData = cFRequestDataArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CFRequestDataSerializer.putOptionalCFRequestDataVarArray(iSerializer, this.val$telCFRequestData);
    }
}

