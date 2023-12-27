/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.CarFunctionSerializer;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.CarFunction;

class DSISearchProxy$6
implements ISerializable {
    private final /* synthetic */ CarFunction[] val$carfunctions;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$6(DSISearchProxy dSISearchProxy, CarFunction[] carFunctionArray) {
        this.this$0 = dSISearchProxy;
        this.val$carfunctions = carFunctionArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        CarFunctionSerializer.putOptionalCarFunctionVarArray(iSerializer, this.val$carfunctions);
    }
}

