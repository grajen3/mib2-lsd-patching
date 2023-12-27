/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewProxy;
import de.esolutions.fw.comm.dsi.komoview.impl.RouteInfoElementSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.komoview.RouteInfoElement;

class DSIKOMOViewProxy$2
implements ISerializable {
    private final /* synthetic */ RouteInfoElement[] val$riElements;
    private final /* synthetic */ DSIKOMOViewProxy this$0;

    DSIKOMOViewProxy$2(DSIKOMOViewProxy dSIKOMOViewProxy, RouteInfoElement[] routeInfoElementArray) {
        this.this$0 = dSIKOMOViewProxy;
        this.val$riElements = routeInfoElementArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteInfoElementSerializer.putOptionalRouteInfoElementVarArray(iSerializer, this.val$riElements);
    }
}

