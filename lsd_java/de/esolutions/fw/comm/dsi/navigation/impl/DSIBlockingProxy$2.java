/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSIBlockingProxy$2
implements ISerializable {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ DSIBlockingProxy this$0;

    DSIBlockingProxy$2(DSIBlockingProxy dSIBlockingProxy, NavLocation navLocation) {
        this.this$0 = dSIBlockingProxy;
        this.val$location = navLocation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$location);
    }
}

