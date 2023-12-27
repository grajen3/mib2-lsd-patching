/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoProxy;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class MapRegionInfoProxy$1
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$location;
    private final /* synthetic */ int val$requestID;
    private final /* synthetic */ MapRegionInfoProxy this$0;

    MapRegionInfoProxy$1(MapRegionInfoProxy mapRegionInfoProxy, NavLocationWgs84 navLocationWgs84, int n) {
        this.this$0 = mapRegionInfoProxy;
        this.val$location = navLocationWgs84;
        this.val$requestID = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$location);
        iSerializer.putUInt16(this.val$requestID);
    }
}

