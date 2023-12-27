/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;

class DSINavigationProxy$23
implements ISerializable {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$23(DSINavigationProxy dSINavigationProxy, Route route) {
        this.this$0 = dSINavigationProxy;
        this.val$route = route;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteSerializer.putOptionalRoute(iSerializer, this.val$route);
    }
}

