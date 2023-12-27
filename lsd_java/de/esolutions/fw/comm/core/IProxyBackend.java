/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.util.serializer.ISerializable;

public interface IProxyBackend {
    default public void remoteCallMethod(short s, short s2, ISerializable iSerializable, ICallMethodSerializeCallback iCallMethodSerializeCallback) {
    }

    default public void proxyAliveDone(Proxy proxy) {
    }

    default public short getPeerAgentID() {
    }
}

