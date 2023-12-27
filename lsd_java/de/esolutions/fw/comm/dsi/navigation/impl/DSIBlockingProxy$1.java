/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.navigation.impl.DSIBlockingProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class DSIBlockingProxy$1
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$southWestCorner;
    private final /* synthetic */ NavLocationWgs84 val$northEastCorner;
    private final /* synthetic */ DSIBlockingProxy this$0;

    DSIBlockingProxy$1(DSIBlockingProxy dSIBlockingProxy, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        this.this$0 = dSIBlockingProxy;
        this.val$southWestCorner = navLocationWgs84;
        this.val$northEastCorner = navLocationWgs842;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$southWestCorner);
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$northEastCorner);
    }
}

