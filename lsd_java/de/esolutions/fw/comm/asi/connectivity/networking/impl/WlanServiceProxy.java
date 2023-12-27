/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanService;
import de.esolutions.fw.comm.asi.connectivity.networking.WlanServiceC;
import de.esolutions.fw.comm.asi.connectivity.networking.WlanServiceReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class WlanServiceProxy
implements WlanService,
WlanServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.WlanService");
    private Proxy proxy;

    public WlanServiceProxy(int n, WlanServiceReply wlanServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a8dd8b55-e7a4-4e4c-9a19-7190de239733", n, "23ffe4de-e647-5fd3-a2d9-abfa30544618", "asi.connectivity.networking.WlanService");
        WlanServiceReplyService wlanServiceReplyService = new WlanServiceReplyService(wlanServiceReply);
        this.proxy = new Proxy(serviceInstanceID, wlanServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }
}

