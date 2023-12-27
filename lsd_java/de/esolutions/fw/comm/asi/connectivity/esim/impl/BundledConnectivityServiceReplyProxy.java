/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.esim.impl;

import de.esolutions.fw.comm.asi.connectivity.esim.BundledConnectivityServiceReply;
import de.esolutions.fw.comm.asi.connectivity.esim.impl.BundledConnectivityServiceReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BundledConnectivityServiceReplyProxy
implements BundledConnectivityServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.esim.BundledConnectivityService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public BundledConnectivityServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f7eca295-e271-472f-bce3-6b7c569ceae6", -1, "1ae1aea9-f1d3-5c1f-8af6-5b7c05cd405d", "asi.connectivity.esim.BundledConnectivityService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateSmsTriggerReceived(int n) {
        BundledConnectivityServiceReplyProxy$1 bundledConnectivityServiceReplyProxy$1 = new BundledConnectivityServiceReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)0, bundledConnectivityServiceReplyProxy$1);
    }
}

