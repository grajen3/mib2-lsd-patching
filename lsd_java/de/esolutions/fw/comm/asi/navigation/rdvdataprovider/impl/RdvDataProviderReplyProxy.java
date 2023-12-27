/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderReply;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$1;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$2;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$3;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$4;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$5;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$6;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$7;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$8;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy$9;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import org.dsi.ifc.global.NavLocationWgs84;

public class RdvDataProviderReplyProxy
implements RdvDataProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.rdvdataprovider.RdvDataProvider");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public RdvDataProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3ee92857-84ba-4dfa-9faf-1d67977f4b5d", -1, "0b921357-9ff8-587c-9c54-67ccfc58e880", "asi.navigation.rdvdataprovider.RdvDataProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void registerForDataUpdateResult(int n) {
        RdvDataProviderReplyProxy$1 rdvDataProviderReplyProxy$1 = new RdvDataProviderReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)3, rdvDataProviderReplyProxy$1);
    }

    @Override
    public void unregisterForDataUpdateResult(int n) {
        RdvDataProviderReplyProxy$2 rdvDataProviderReplyProxy$2 = new RdvDataProviderReplyProxy$2(this, n);
        this.proxy.remoteCallMethod((short)5, rdvDataProviderReplyProxy$2);
    }

    @Override
    public void updateDemoModeStatus(boolean bl) {
        RdvDataProviderReplyProxy$3 rdvDataProviderReplyProxy$3 = new RdvDataProviderReplyProxy$3(this, bl);
        this.proxy.remoteCallMethod((short)8, rdvDataProviderReplyProxy$3);
    }

    @Override
    public void updateRouteGuidanceStatus(boolean bl) {
        RdvDataProviderReplyProxy$4 rdvDataProviderReplyProxy$4 = new RdvDataProviderReplyProxy$4(this, bl);
        this.proxy.remoteCallMethod((short)9, rdvDataProviderReplyProxy$4);
    }

    @Override
    public void updateCurrentRouteOptions(RdvRouteOptions rdvRouteOptions) {
        RdvDataProviderReplyProxy$5 rdvDataProviderReplyProxy$5 = new RdvDataProviderReplyProxy$5(this, rdvRouteOptions);
        this.proxy.remoteCallMethod((short)10, rdvDataProviderReplyProxy$5);
    }

    @Override
    public void updateCurrentRoute(NavLocationWgs84[] navLocationWgs84Array) {
        RdvDataProviderReplyProxy$6 rdvDataProviderReplyProxy$6 = new RdvDataProviderReplyProxy$6(this, navLocationWgs84Array);
        this.proxy.remoteCallMethod((short)6, rdvDataProviderReplyProxy$6);
    }

    @Override
    public void updateStopovers(NavLocationWgs84[] navLocationWgs84Array) {
        RdvDataProviderReplyProxy$7 rdvDataProviderReplyProxy$7 = new RdvDataProviderReplyProxy$7(this, navLocationWgs84Array);
        this.proxy.remoteCallMethod((short)11, rdvDataProviderReplyProxy$7);
    }

    @Override
    public void setRouteProviderSettingResult(RouteProviderSetting routeProviderSetting, int n) {
        RdvDataProviderReplyProxy$8 rdvDataProviderReplyProxy$8 = new RdvDataProviderReplyProxy$8(this, routeProviderSetting, n);
        this.proxy.remoteCallMethod((short)13, rdvDataProviderReplyProxy$8);
    }

    @Override
    public void getCurrentPositionResult(NavLocationWgs84 navLocationWgs84) {
        RdvDataProviderReplyProxy$9 rdvDataProviderReplyProxy$9 = new RdvDataProviderReplyProxy$9(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)1, rdvDataProviderReplyProxy$9);
    }
}

