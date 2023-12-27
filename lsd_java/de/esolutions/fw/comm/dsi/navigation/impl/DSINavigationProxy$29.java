/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$29
implements ISerializable {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ int val$type;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$29(DSINavigationProxy dSINavigationProxy, NavLocation navLocation, int n) {
        this.this$0 = dSINavigationProxy;
        this.val$location = navLocation;
        this.val$type = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$location);
        iSerializer.putInt32(this.val$type);
    }
}

