/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RouteProviderSettingSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class RdvDataProviderReplyProxy$8
implements ISerializable {
    private final /* synthetic */ RouteProviderSetting val$setting;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ RdvDataProviderReplyProxy this$0;

    RdvDataProviderReplyProxy$8(RdvDataProviderReplyProxy rdvDataProviderReplyProxy, RouteProviderSetting routeProviderSetting, int n) {
        this.this$0 = rdvDataProviderReplyProxy;
        this.val$setting = routeProviderSetting;
        this.val$validFlag = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RouteProviderSettingSerializer.putOptionalRouteProviderSetting(iSerializer, this.val$setting);
        iSerializer.putEnum(this.val$validFlag);
    }
}

