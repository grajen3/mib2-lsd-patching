/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.ComponentProtectionReply;
import de.esolutions.fw.comm.asi.fec.impl.ComponentProtectionReplyProxy$1;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class ComponentProtectionReplyProxy
implements ComponentProtectionReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.ComponentProtection");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public ComponentProtectionReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9e66ab21-39b4-11e0-9e42-0800200c9a66", -1, "73f457d8-4826-5389-912d-2ec567427974", "asi.fec.ComponentProtection");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void authStringResult(String string, String string2, byte by) {
        ComponentProtectionReplyProxy$1 componentProtectionReplyProxy$1 = new ComponentProtectionReplyProxy$1(this, string, string2, by);
        this.proxy.remoteCallMethod((short)1, componentProtectionReplyProxy$1);
    }
}

