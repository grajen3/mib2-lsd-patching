/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingServiceReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy$2;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy$3;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy$4;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy$5;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy$6;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class NetworkingServiceReplyProxy
implements NetworkingServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.NetworkingService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public NetworkingServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("54bd523b-eece-4101-9c88-53bb869c6b64", -1, "9d2b4f14-42b2-506b-aae0-1904af2be1f8", "asi.connectivity.networking.NetworkingService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateRoamingState(int n) {
        NetworkingServiceReplyProxy$1 networkingServiceReplyProxy$1 = new NetworkingServiceReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)1, networkingServiceReplyProxy$1);
    }

    @Override
    public void updateOnlineState(int n) {
        NetworkingServiceReplyProxy$2 networkingServiceReplyProxy$2 = new NetworkingServiceReplyProxy$2(this, n);
        this.proxy.remoteCallMethod((short)0, networkingServiceReplyProxy$2);
    }

    @Override
    public void updateThrottlingState(int n) {
        NetworkingServiceReplyProxy$3 networkingServiceReplyProxy$3 = new NetworkingServiceReplyProxy$3(this, n);
        this.proxy.remoteCallMethod((short)3, networkingServiceReplyProxy$3);
    }

    @Override
    public void updateServiceIdentifier(String string) {
        NetworkingServiceReplyProxy$4 networkingServiceReplyProxy$4 = new NetworkingServiceReplyProxy$4(this, string);
        this.proxy.remoteCallMethod((short)2, networkingServiceReplyProxy$4);
    }

    @Override
    public void updateSimCardType(int n) {
        NetworkingServiceReplyProxy$5 networkingServiceReplyProxy$5 = new NetworkingServiceReplyProxy$5(this, n);
        this.proxy.remoteCallMethod((short)4, networkingServiceReplyProxy$5);
    }

    @Override
    public void updateSim(String string, String string2, String string3, String string4) {
        NetworkingServiceReplyProxy$6 networkingServiceReplyProxy$6 = new NetworkingServiceReplyProxy$6(this, string, string2, string3, string4);
        this.proxy.remoteCallMethod((short)6, networkingServiceReplyProxy$6);
    }
}

