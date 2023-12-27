/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingBluetoothBridgeReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NetworkingBluetoothBridgeReplyProxy$1
implements ISerializable {
    private final /* synthetic */ long val$addr;
    private final /* synthetic */ int val$profile;
    private final /* synthetic */ int val$state;
    private final /* synthetic */ NetworkingBluetoothBridgeReplyProxy this$0;

    NetworkingBluetoothBridgeReplyProxy$1(NetworkingBluetoothBridgeReplyProxy networkingBluetoothBridgeReplyProxy, long l, int n, int n2) {
        this.this$0 = networkingBluetoothBridgeReplyProxy;
        this.val$addr = l;
        this.val$profile = n;
        this.val$state = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$addr);
        iSerializer.putEnum(this.val$profile);
        iSerializer.putEnum(this.val$state);
    }
}

