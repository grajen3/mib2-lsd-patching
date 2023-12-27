/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$18
implements ISerializable {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$18(DSINavigationProxy dSINavigationProxy, NavLocation navLocation) {
        this.this$0 = dSINavigationProxy;
        this.val$navLocation = navLocation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$navLocation);
    }
}

