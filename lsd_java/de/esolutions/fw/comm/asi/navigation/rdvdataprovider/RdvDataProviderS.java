/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderReply;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;

public interface RdvDataProviderS {
    default public void registerForDataUpdate(RdvDataProviderReply rdvDataProviderReply) {
    }

    default public void unregisterForDataUpdate(RdvDataProviderReply rdvDataProviderReply) {
    }

    default public void setRouteProviderSetting(RouteProviderSetting routeProviderSetting, RdvDataProviderReply rdvDataProviderReply) {
    }

    default public void getCurrentPosition(RdvDataProviderReply rdvDataProviderReply) {
    }
}

