/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;

public interface RdvDataProviderC {
    default public void registerForDataUpdate() {
    }

    default public void unregisterForDataUpdate() {
    }

    default public void setRouteProviderSetting(RouteProviderSetting routeProviderSetting) {
    }

    default public void getCurrentPosition() {
    }
}

