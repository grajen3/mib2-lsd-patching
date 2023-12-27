/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.comm.dsi.navigation.impl.RouteSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.Route;

class DSINavigationProxy$4
implements ISerializable {
    private final /* synthetic */ Route val$route;
    private final /* synthetic */ String val$title;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$4(DSINavigationProxy dSINavigationProxy, Route route, String string) {
        this.this$0 = dSINavigationProxy;
        this.val$route = route;
        this.val$title = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteSerializer.putOptionalRoute(iSerializer, this.val$route);
        iSerializer.putOptionalString(this.val$title);
    }
}

