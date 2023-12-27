/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderProxy;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RouteProviderSettingSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class RdvDataProviderProxy$1
implements ISerializable {
    private final /* synthetic */ RouteProviderSetting val$setting;
    private final /* synthetic */ RdvDataProviderProxy this$0;

    RdvDataProviderProxy$1(RdvDataProviderProxy rdvDataProviderProxy, RouteProviderSetting routeProviderSetting) {
        this.this$0 = rdvDataProviderProxy;
        this.val$setting = routeProviderSetting;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteProviderSettingSerializer.putOptionalRouteProviderSetting(iSerializer, this.val$setting);
    }
}

