/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IProxyConnector
extends IProxyListener {
    default public void connectProxy(Proxy proxy) {
    }

    default public void disconnectProxy(Proxy proxy) {
    }

    default public void registerProxyListener(Proxy proxy, IProxyListener iProxyListener, boolean bl) {
    }

    default public void registerRemoteReplyService(ServiceInstanceID serviceInstanceID, short s) {
    }

    default public void unregisterRemoteReplyService(ServiceInstanceID serviceInstanceID, short s) {
    }
}

