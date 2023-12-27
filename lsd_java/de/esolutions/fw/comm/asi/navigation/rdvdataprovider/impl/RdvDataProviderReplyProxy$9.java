/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

class RdvDataProviderReplyProxy$9
implements ISerializable {
    private final /* synthetic */ NavLocationWgs84 val$point;
    private final /* synthetic */ RdvDataProviderReplyProxy this$0;

    RdvDataProviderReplyProxy$9(RdvDataProviderReplyProxy rdvDataProviderReplyProxy, NavLocationWgs84 navLocationWgs84) {
        this.this$0 = rdvDataProviderReplyProxy;
        this.val$point = navLocationWgs84;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, this.val$point);
    }
}

