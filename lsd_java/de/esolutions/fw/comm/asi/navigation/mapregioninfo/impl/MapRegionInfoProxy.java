/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoC;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoProxy$1;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoProxy$2;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoProxy$3;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public class MapRegionInfoProxy
implements MapRegionInfo,
MapRegionInfoC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.mapregioninfo.MapRegionInfo");
    private Proxy proxy;

    public MapRegionInfoProxy(int n, MapRegionInfoReply mapRegionInfoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3beb5497-ae2a-4128-9f05-6068d21ac40f", n, "f203c2e7-a0c6-56da-ae80-1a6f30666d1f", "asi.navigation.mapregioninfo.MapRegionInfo");
        MapRegionInfoReplyService mapRegionInfoReplyService = new MapRegionInfoReplyService(mapRegionInfoReply);
        this.proxy = new Proxy(serviceInstanceID, mapRegionInfoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestGetDatabaseInfo(NavLocationWgs84 navLocationWgs84, int n) {
        MapRegionInfoProxy$1 mapRegionInfoProxy$1 = new MapRegionInfoProxy$1(this, navLocationWgs84, n);
        this.proxy.remoteCallMethod((short)3, mapRegionInfoProxy$1);
    }

    @Override
    public void requestGetMultipleDatabaseInfo(NavLocationWgs84[] navLocationWgs84Array, int n) {
        MapRegionInfoProxy$2 mapRegionInfoProxy$2 = new MapRegionInfoProxy$2(this, navLocationWgs84Array, n);
        this.proxy.remoteCallMethod((short)4, mapRegionInfoProxy$2);
    }

    @Override
    public void requestGetRegionsInVicinity(NavRectangle navRectangle, int n) {
        MapRegionInfoProxy$3 mapRegionInfoProxy$3 = new MapRegionInfoProxy$3(this, navRectangle, n);
        this.proxy.remoteCallMethod((short)6, mapRegionInfoProxy$3);
    }
}

