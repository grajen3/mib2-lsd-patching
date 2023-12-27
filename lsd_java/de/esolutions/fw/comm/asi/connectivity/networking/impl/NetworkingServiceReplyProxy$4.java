/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NetworkingServiceReplyProxy$4
implements ISerializable {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ NetworkingServiceReplyProxy this$0;

    NetworkingServiceReplyProxy$4(NetworkingServiceReplyProxy networkingServiceReplyProxy, String string) {
        this.this$0 = networkingServiceReplyProxy;
        this.val$id = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$id);
    }
}

