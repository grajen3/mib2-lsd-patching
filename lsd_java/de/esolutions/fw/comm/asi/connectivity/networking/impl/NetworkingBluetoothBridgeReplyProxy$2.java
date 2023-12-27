/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingBluetoothBridgeReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class NetworkingBluetoothBridgeReplyProxy$2
implements ISerializable {
    private final /* synthetic */ long val$addr;
    private final /* synthetic */ int val$profile;
    private final /* synthetic */ boolean val$connectable;
    private final /* synthetic */ NetworkingBluetoothBridgeReplyProxy this$0;

    NetworkingBluetoothBridgeReplyProxy$2(NetworkingBluetoothBridgeReplyProxy networkingBluetoothBridgeReplyProxy, long l, int n, boolean bl) {
        this.this$0 = networkingBluetoothBridgeReplyProxy;
        this.val$addr = l;
        this.val$profile = n;
        this.val$connectable = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$addr);
        iSerializer.putEnum(this.val$profile);
        iSerializer.putBool(this.val$connectable);
    }
}

