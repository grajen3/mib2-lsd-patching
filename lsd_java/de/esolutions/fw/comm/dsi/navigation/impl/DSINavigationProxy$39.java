/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;

class DSINavigationProxy$39
implements ISerializable {
    private final /* synthetic */ NavLocation val$city;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$39(DSINavigationProxy dSINavigationProxy, NavLocation navLocation) {
        this.this$0 = dSINavigationProxy;
        this.val$city = navLocation;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationSerializer.putOptionalNavLocation(iSerializer, this.val$city);
    }
}

