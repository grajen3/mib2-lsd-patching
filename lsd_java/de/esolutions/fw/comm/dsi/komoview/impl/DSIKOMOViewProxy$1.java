/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.comm.dsi.komoview.impl.DSIKOMOViewProxy;
import de.esolutions.fw.comm.dsi.komoview.impl.RouteInfoElementSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.komoview.RouteInfoElement;

class DSIKOMOViewProxy$1
implements ISerializable {
    private final /* synthetic */ RouteInfoElement val$riElement;
    private final /* synthetic */ DSIKOMOViewProxy this$0;

    DSIKOMOViewProxy$1(DSIKOMOViewProxy dSIKOMOViewProxy, RouteInfoElement routeInfoElement) {
        this.this$0 = dSIKOMOViewProxy;
        this.val$riElement = routeInfoElement;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteInfoElementSerializer.putOptionalRouteInfoElement(iSerializer, this.val$riElement);
    }
}

