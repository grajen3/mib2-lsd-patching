/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;

class DSINavigationProxy$24
implements ISerializable {
    private final /* synthetic */ int val$rmID;
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ String val$name;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$24(DSINavigationProxy dSINavigationProxy, int n, Route route, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$rmID = n;
        this.val$route = route;
        this.val$name = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$rmID);
        RouteSerializer.putOptionalRoute(iSerializer, this.val$route);
        iSerializer.putOptionalString(this.val$name);
    }
}

