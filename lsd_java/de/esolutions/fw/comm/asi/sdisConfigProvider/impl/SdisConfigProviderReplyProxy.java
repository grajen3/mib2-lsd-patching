/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.asi.sdisConfigProvider.impl.SdisConfigProviderReplyProxy$1;
import de.esolutions.fw.comm.asi.sdisConfigProvider.impl.SdisConfigProviderReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class SdisConfigProviderReplyProxy
implements SdisConfigProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.sdisConfigProvider.SdisConfigProvider");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public SdisConfigProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4005e13e-09f0-11e5-94dc-54ee7547f476", -1, "417013af-3c71-5487-8fc9-6d656a950fc5", "asi.sdisConfigProvider.SdisConfigProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateConfig(int n, long l) {
        SdisConfigProviderReplyProxy$1 sdisConfigProviderReplyProxy$1 = new SdisConfigProviderReplyProxy$1(this, n, l);
        this.proxy.remoteCallMethod((short)7, sdisConfigProviderReplyProxy$1);
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
        SdisConfigProviderReplyProxy$2 sdisConfigProviderReplyProxy$2 = new SdisConfigProviderReplyProxy$2(this, string, bl);
        this.proxy.remoteCallMethod((short)6, sdisConfigProviderReplyProxy$2);
    }
}

