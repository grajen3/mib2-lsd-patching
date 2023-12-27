/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoProxy;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;

class MapRegionInfoProxy$3
implements ISerializable {
    private final /* synthetic */ NavRectangle val$locationArea;
    private final /* synthetic */ int val$requestID;
    private final /* synthetic */ MapRegionInfoProxy this$0;

    MapRegionInfoProxy$3(MapRegionInfoProxy mapRegionInfoProxy, NavRectangle navRectangle, int n) {
        this.this$0 = mapRegionInfoProxy;
        this.val$locationArea = navRectangle;
        this.val$requestID = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavRectangleSerializer.putOptionalNavRectangle(iSerializer, this.val$locationArea);
        iSerializer.putUInt16(this.val$requestID);
    }
}

