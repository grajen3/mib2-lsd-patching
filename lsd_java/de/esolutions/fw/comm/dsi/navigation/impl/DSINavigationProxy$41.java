/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSINavigationProxy$41
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$position;
    private final /* synthetic */ DSINavigationProxy this$0;

    DSINavigationProxy$41(DSINavigationProxy dSINavigationProxy, NavLocationWgs84 navLocationWgs84) {
        this.this$0 = dSINavigationProxy;
        this.val$position = navLocationWgs84;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$position);
    }
}

