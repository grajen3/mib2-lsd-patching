/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingServiceS;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.NetworkingServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class NetworkingServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.NetworkingService");
    private NetworkingServiceS p_NetworkingService;

    public NetworkingServiceService(int n, NetworkingServiceS networkingServiceS) {
        super(new ServiceInstanceID("787ceeb7-47e1-460a-97ff-41dcdf5056a3", n, "076ce6c8-16a7-5c69-b58d-be1eed3e44d2", "asi.connectivity.networking.NetworkingService"));
        this.p_NetworkingService = networkingServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new NetworkingServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        switch (s) {
            default: 
        }
        throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
    }
}

