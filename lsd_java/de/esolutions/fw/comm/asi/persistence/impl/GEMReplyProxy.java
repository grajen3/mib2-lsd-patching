/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.GEMReply;
import de.esolutions.fw.comm.asi.persistence.impl.GEMReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class GEMReplyProxy
implements GEMReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.persistence.GEM");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public GEMReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("116d951a-df12-5d02-93b4-69573b9d69b5", -1, "eddb9230-0b3c-558e-b321-dbb0a049fbfb", "asi.persistence.GEM");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void gemActive(boolean bl) {
        GEMReplyProxy$1 gEMReplyProxy$1 = new GEMReplyProxy$1(this, bl);
        this.proxy.remoteCallMethod((short)0, gEMReplyProxy$1);
    }
}

