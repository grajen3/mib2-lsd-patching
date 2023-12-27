/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;

class DSINavigationProxy$33
implements ISerializable {
    private final /* synthetic */ int val$rmID;
    private final /* synthetic */ long val$routeID;
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$33(DSINavigationProxy dSINavigationProxy, int n, long l, Route route) {
        this.this$0 = dSINavigationProxy;
        this.val$rmID = n;
        this.val$routeID = l;
        this.val$route = route;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$rmID);
        iSerializer.putInt64(this.val$routeID);
        RouteSerializer.putOptionalRoute(iSerializer, this.val$route);
    }
}

