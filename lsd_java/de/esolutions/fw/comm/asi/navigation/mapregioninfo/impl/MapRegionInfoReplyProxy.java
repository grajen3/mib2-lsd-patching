/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyProxy$1;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyProxy$2;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyProxy$3;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class MapRegionInfoReplyProxy
implements MapRegionInfoReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.mapregioninfo.MapRegionInfo");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public MapRegionInfoReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f6ed3bd2-c174-4a4c-a99f-5ca2e73a72e5", -1, "ea59591a-319c-5eba-8c59-1bc981eda986", "asi.navigation.mapregioninfo.MapRegionInfo");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void replyGetDatabaseInfo(int n, ComponentInfo componentInfo, int n2) {
        MapRegionInfoReplyProxy$1 mapRegionInfoReplyProxy$1 = new MapRegionInfoReplyProxy$1(this, n, componentInfo, n2);
        this.proxy.remoteCallMethod((short)0, mapRegionInfoReplyProxy$1);
    }

    @Override
    public void replyGetMultipleDatabaseInfo(int n, ComponentInfo[] componentInfoArray, int n2) {
        MapRegionInfoReplyProxy$2 mapRegionInfoReplyProxy$2 = new MapRegionInfoReplyProxy$2(this, n, componentInfoArray, n2);
        this.proxy.remoteCallMethod((short)1, mapRegionInfoReplyProxy$2);
    }

    @Override
    public void replyGetRegionsInVicinity(int n, ComponentInfo[] componentInfoArray, int n2) {
        MapRegionInfoReplyProxy$3 mapRegionInfoReplyProxy$3 = new MapRegionInfoReplyProxy$3(this, n, componentInfoArray, n2);
        this.proxy.remoteCallMethod((short)2, mapRegionInfoReplyProxy$3);
    }
}

