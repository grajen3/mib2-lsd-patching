/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.dsi.has.impl.DSIHASProxy;
import de.esolutions.fw.comm.dsi.has.impl.HASDataContainerSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.has.HASDataContainer;

class DSIHASProxy$2
implements ISerializable {
    private final /* synthetic */ int val$propertyId;
    private final /* synthetic */ HASDataContainer[] val$propertyData;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSIHASProxy this$0;

    DSIHASProxy$2(DSIHASProxy dSIHASProxy, int n, HASDataContainer[] hASDataContainerArray, int n2) {
        this.this$0 = dSIHASProxy;
        this.val$propertyId = n;
        this.val$propertyData = hASDataContainerArray;
        this.val$resultCode = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$propertyId);
        HASDataContainerSerializer.putOptionalHASDataContainerVarArray(iSerializer, this.val$propertyData);
        iSerializer.putInt32(this.val$resultCode);
    }
}

