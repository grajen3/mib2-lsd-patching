/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;

class DSINavigationProxy$42
implements ISerializable {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ int val$numOfRoutes;
    private final /* synthetic */ boolean val$resumeRoute;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$42(DSINavigationProxy dSINavigationProxy, Route route, int n, boolean bl) {
        this.this$0 = dSINavigationProxy;
        this.val$route = route;
        this.val$numOfRoutes = n;
        this.val$resumeRoute = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteSerializer.putOptionalRoute(iSerializer, this.val$route);
        iSerializer.putInt32(this.val$numOfRoutes);
        iSerializer.putBool(this.val$resumeRoute);
    }
}

