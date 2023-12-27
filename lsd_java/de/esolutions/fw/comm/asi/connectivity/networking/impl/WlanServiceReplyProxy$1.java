/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class WlanServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ boolean val$isReady;
    private final /* synthetic */ String val$local_addr;
    private final /* synthetic */ WlanServiceReplyProxy this$0;

    WlanServiceReplyProxy$1(WlanServiceReplyProxy wlanServiceReplyProxy, boolean bl, String string) {
        this.this$0 = wlanServiceReplyProxy;
        this.val$isReady = bl;
        this.val$local_addr = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$isReady);
        iSerializer.putOptionalString(this.val$local_addr);
    }
}

