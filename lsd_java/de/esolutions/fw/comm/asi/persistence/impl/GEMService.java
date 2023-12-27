/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.GEMS;
import de.esolutions.fw.comm.asi.persistence.impl.GEMReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class GEMService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.persistence.GEM");
    private GEMS p_GEM;

    public GEMService(int n, GEMS gEMS) {
        super(new ServiceInstanceID("c7f869df-1be1-5090-ba2d-aed8a69db8ea", n, "d40de8e3-b01e-505f-bf5f-eaeb5f97a86f", "asi.persistence.GEM"));
        this.p_GEM = gEMS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new GEMReplyProxy();
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

