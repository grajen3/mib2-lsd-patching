/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceReply;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl.UOTANaviServiceReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class UOTANaviServiceReplyProxy
implements UOTANaviServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.uotanaviservice.UOTANaviService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public UOTANaviServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("0d894ae4-0f7c-48e6-a7e3-0b9f0d32c51a", -1, "5e467618-909a-51d8-837e-36f5bbfa36a1", "asi.navigation.uotanaviservice.UOTANaviService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void getVersionInfo(short s) {
        UOTANaviServiceReplyProxy$1 uOTANaviServiceReplyProxy$1 = new UOTANaviServiceReplyProxy$1(this, s);
        this.proxy.remoteCallMethod((short)0, uOTANaviServiceReplyProxy$1);
    }
}

