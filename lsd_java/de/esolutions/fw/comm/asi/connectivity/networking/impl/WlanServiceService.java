/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanServiceS;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class WlanServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.networking.WlanService");
    private WlanServiceS p_WlanService;

    public WlanServiceService(int n, WlanServiceS wlanServiceS) {
        super(new ServiceInstanceID("a8dd8b55-e7a4-4e4c-9a19-7190de239733", n, "23ffe4de-e647-5fd3-a2d9-abfa30544618", "asi.connectivity.networking.WlanService"));
        this.p_WlanService = wlanServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new WlanServiceReplyProxy();
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

