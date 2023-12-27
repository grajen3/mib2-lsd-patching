/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingService;
import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingServiceC;
import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingServiceReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class NetworkingServiceProxy
implements NetworkingService,
NetworkingServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.NetworkingService");
    private Proxy proxy;

    public NetworkingServiceProxy(int n, NetworkingServiceReply networkingServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("787ceeb7-47e1-460a-97ff-41dcdf5056a3", n, "076ce6c8-16a7-5c69-b58d-be1eed3e44d2", "asi.connectivity.networking.NetworkingService");
        NetworkingServiceReplyService networkingServiceReplyService = new NetworkingServiceReplyService(networkingServiceReply);
        this.proxy = new Proxy(serviceInstanceID, networkingServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }
}

