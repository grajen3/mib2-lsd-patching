/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.esim.impl;

import de.esolutions.fw.comm.asi.connectivity.esim.BundledConnectivityService;
import de.esolutions.fw.comm.asi.connectivity.esim.BundledConnectivityServiceC;
import de.esolutions.fw.comm.asi.connectivity.esim.BundledConnectivityServiceReply;
import de.esolutions.fw.comm.asi.connectivity.esim.impl.BundledConnectivityServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BundledConnectivityServiceProxy
implements BundledConnectivityService,
BundledConnectivityServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.esim.BundledConnectivityService");
    private Proxy proxy;

    public BundledConnectivityServiceProxy(int n, BundledConnectivityServiceReply bundledConnectivityServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2dedf1b5-a689-4962-9b6f-c69115090823", n, "aace4ec3-c587-5154-ac22-80b348848d05", "asi.connectivity.esim.BundledConnectivityService");
        BundledConnectivityServiceReplyService bundledConnectivityServiceReplyService = new BundledConnectivityServiceReplyService(bundledConnectivityServiceReply);
        this.proxy = new Proxy(serviceInstanceID, bundledConnectivityServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }
}

