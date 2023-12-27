/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.GEM;
import de.esolutions.fw.comm.asi.persistence.GEMC;
import de.esolutions.fw.comm.asi.persistence.GEMReply;
import de.esolutions.fw.comm.asi.persistence.impl.GEMReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class GEMProxy
implements GEM,
GEMC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.persistence.GEM");
    private Proxy proxy;

    public GEMProxy(int n, GEMReply gEMReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c7f869df-1be1-5090-ba2d-aed8a69db8ea", n, "d40de8e3-b01e-505f-bf5f-eaeb5f97a86f", "asi.persistence.GEM");
        GEMReplyService gEMReplyService = new GEMReplyService(gEMReply);
        this.proxy = new Proxy(serviceInstanceID, gEMReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }
}

