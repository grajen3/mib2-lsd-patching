/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.RdvRouteOptionsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class RdvDataProviderReplyProxy$5
implements ISerializable {
    private final /* synthetic */ RdvRouteOptions val$options;
    private final /* synthetic */ RdvDataProviderReplyProxy this$0;

    RdvDataProviderReplyProxy$5(RdvDataProviderReplyProxy rdvDataProviderReplyProxy, RdvRouteOptions rdvRouteOptions) {
        this.this$0 = rdvDataProviderReplyProxy;
        this.val$options = rdvRouteOptions;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        RdvRouteOptionsSerializer.putOptionalRdvRouteOptions(iSerializer, this.val$options);
    }
}

