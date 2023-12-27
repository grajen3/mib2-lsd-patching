/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class RdvDataProviderReplyProxy$3
implements ISerializable {
    private final /* synthetic */ boolean val$isActive;
    private final /* synthetic */ RdvDataProviderReplyProxy this$0;

    RdvDataProviderReplyProxy$3(RdvDataProviderReplyProxy rdvDataProviderReplyProxy, boolean bl) {
        this.this$0 = rdvDataProviderReplyProxy;
        this.val$isActive = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$isActive);
    }
}

