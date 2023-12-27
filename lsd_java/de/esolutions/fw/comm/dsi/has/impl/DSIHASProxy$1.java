/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.dsi.has.impl.DSIHASProxy;
import de.esolutions.fw.comm.dsi.has.impl.HASDataContainerSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.has.HASDataContainer;

class DSIHASProxy$1
implements ISerializable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ int val$actionId;
    private final /* synthetic */ HASDataContainer[] val$actionResultData;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSIHASProxy this$0;

    DSIHASProxy$1(DSIHASProxy dSIHASProxy, int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
        this.this$0 = dSIHASProxy;
        this.val$requestId = n;
        this.val$actionId = n2;
        this.val$actionResultData = hASDataContainerArray;
        this.val$resultCode = n3;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$requestId);
        iSerializer.putInt32(this.val$actionId);
        HASDataContainerSerializer.putOptionalHASDataContainerVarArray(iSerializer, this.val$actionResultData);
        iSerializer.putInt32(this.val$resultCode);
    }
}

