/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import org.dsi.ifc.global.NavLocationWgs84;

public interface RdvDataProviderReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void registerForDataUpdateResult(int n) {
    }

    default public void unregisterForDataUpdateResult(int n) {
    }

    default public void updateDemoModeStatus(boolean bl) {
    }

    default public void updateRouteGuidanceStatus(boolean bl) {
    }

    default public void updateCurrentRouteOptions(RdvRouteOptions rdvRouteOptions) {
    }

    default public void updateCurrentRoute(NavLocationWgs84[] navLocationWgs84Array) {
    }

    default public void updateStopovers(NavLocationWgs84[] navLocationWgs84Array) {
    }

    default public void setRouteProviderSettingResult(RouteProviderSetting routeProviderSetting, int n) {
    }

    default public void getCurrentPositionResult(NavLocationWgs84 navLocationWgs84) {
    }
}

