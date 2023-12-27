/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteOptionsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RouteOptions;

class DSINavigationProxy$22
implements ISerializable {
    private final /* synthetic */ RouteOptions val$routeOptions;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$22(DSINavigationProxy dSINavigationProxy, RouteOptions routeOptions) {
        this.this$0 = dSINavigationProxy;
        this.val$routeOptions = routeOptions;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteOptionsSerializer.putOptionalRouteOptions(iSerializer, this.val$routeOptions);
    }
}

