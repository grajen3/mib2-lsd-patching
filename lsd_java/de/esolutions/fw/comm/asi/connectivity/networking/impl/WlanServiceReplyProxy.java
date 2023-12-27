/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;
import de.esolutions.fw.comm.asi.connectivity.networking.WlanServiceReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanServiceReplyProxy$1;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanServiceReplyProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class WlanServiceReplyProxy
implements WlanServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.WlanService");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public WlanServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("24fd4522-b997-4cd5-b2f8-890d6c224eb0", -1, "7475049f-9ea8-5f56-ab00-5c258cd1be7f", "asi.connectivity.networking.WlanService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void updateWlanReady(boolean bl, String string) {
        WlanServiceReplyProxy$1 wlanServiceReplyProxy$1 = new WlanServiceReplyProxy$1(this, bl, string);
        this.proxy.remoteCallMethod((short)2, wlanServiceReplyProxy$1);
    }

    @Override
    public void updateWLANDevice(WlanDevice wlanDevice) {
        WlanServiceReplyProxy$2 wlanServiceReplyProxy$2 = new WlanServiceReplyProxy$2(this, wlanDevice);
        this.proxy.remoteCallMethod((short)3, wlanServiceReplyProxy$2);
    }
}

