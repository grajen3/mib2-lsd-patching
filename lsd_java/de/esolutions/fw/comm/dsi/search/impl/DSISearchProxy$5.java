/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.NavPositionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.NavPosition;

class DSISearchProxy$5
implements ISerializable {
    private final /* synthetic */ NavPosition[] val$routePoints;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$5(DSISearchProxy dSISearchProxy, NavPosition[] navPositionArray) {
        this.this$0 = dSISearchProxy;
        this.val$routePoints = navPositionArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavPositionSerializer.putOptionalNavPositionVarArray(iSerializer, this.val$routePoints);
    }
}

