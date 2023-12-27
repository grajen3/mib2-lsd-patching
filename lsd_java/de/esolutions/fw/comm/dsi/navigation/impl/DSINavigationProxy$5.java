/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;

class DSINavigationProxy$5
implements ISerializable {
    private final /* synthetic */ long val$routeID;
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ String val$title;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$5(DSINavigationProxy dSINavigationProxy, long l, Route route, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$routeID = l;
        this.val$route = route;
        this.val$title = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$routeID);
        RouteSerializer.putOptionalRoute(iSerializer, this.val$route);
        iSerializer.putOptionalString(this.val$title);
    }
}

