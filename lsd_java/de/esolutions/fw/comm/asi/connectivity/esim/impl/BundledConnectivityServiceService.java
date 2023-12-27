/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.esim.impl;

import de.esolutions.fw.comm.asi.connectivity.esim.BundledConnectivityServiceS;
import de.esolutions.fw.comm.asi.connectivity.esim.impl.BundledConnectivityServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class BundledConnectivityServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.connectivity.esim.BundledConnectivityService");
    private BundledConnectivityServiceS p_BundledConnectivityService;

    public BundledConnectivityServiceService(int n, BundledConnectivityServiceS bundledConnectivityServiceS) {
        super(new ServiceInstanceID("2dedf1b5-a689-4962-9b6f-c69115090823", n, "aace4ec3-c587-5154-ac22-80b348848d05", "asi.connectivity.esim.BundledConnectivityService"));
        this.p_BundledConnectivityService = bundledConnectivityServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new BundledConnectivityServiceReplyProxy();
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

