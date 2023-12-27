/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NetworkingServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ NetworkingServiceReplyProxy this$0;

    NetworkingServiceReplyProxy$1(NetworkingServiceReplyProxy networkingServiceReplyProxy, int n) {
        this.this$0 = networkingServiceReplyProxy;
        this.val$state = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$state);
    }
}

