/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingBluetoothBridgeReplyProxy$1;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingBluetoothBridgeReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class NetworkingBluetoothBridgeReplyProxy
implements NetworkingBluetoothBridgeReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.NetworkingBluetoothBridge");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public NetworkingBluetoothBridgeReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("455c3e9a-730d-4285-979c-61c4a9648fa2", -1, "473aed0f-a08a-5fd6-ab32-16d904233133", "asi.connectivity.networking.NetworkingBluetoothBridge");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setConnectionState(long l, int n, int n2) {
        NetworkingBluetoothBridgeReplyProxy$1 networkingBluetoothBridgeReplyProxy$1 = new NetworkingBluetoothBridgeReplyProxy$1(this, l, n, n2);
        this.proxy.remoteCallMethod((short)0, networkingBluetoothBridgeReplyProxy$1);
    }

    @Override
    public void setProfileConnectable(long l, int n, boolean bl) {
        NetworkingBluetoothBridgeReplyProxy$2 networkingBluetoothBridgeReplyProxy$2 = new NetworkingBluetoothBridgeReplyProxy$2(this, l, n, bl);
        this.proxy.remoteCallMethod((short)1, networkingBluetoothBridgeReplyProxy$2);
    }
}

