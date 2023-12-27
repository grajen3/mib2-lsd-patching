/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.comm.dsi.search.impl.NavPositionSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.NavPosition;

class DSISearchProxy$4
implements ISerializable {
    private final /* synthetic */ NavPosition val$pos;
    private final /* synthetic */ DSISearchProxy this$0;

    DSISearchProxy$4(DSISearchProxy dSISearchProxy, NavPosition navPosition) {
        this.this$0 = dSISearchProxy;
        this.val$pos = navPosition;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavPositionSerializer.putOptionalNavPosition(iSerializer, this.val$pos);
    }
}

