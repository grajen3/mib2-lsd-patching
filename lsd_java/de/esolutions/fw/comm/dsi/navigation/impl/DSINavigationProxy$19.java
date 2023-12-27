/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$19
implements ISerializable {
    private final /* synthetic */ NavLocation val$poiLocation;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$19(DSINavigationProxy dSINavigationProxy, NavLocation navLocation) {
        this.this$0 = dSINavigationProxy;
        this.val$poiLocation = navLocation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$poiLocation);
    }
}

