/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.Proxy;

public interface IStub {
    public static final short INVALID_ID;

    default public IService getService() {
    }

    default public short getStubID() {
    }

    default public short getRemoteProxyID() {
    }

    default public short getRemoteAgentID() {
    }

    default public IProxyFrontend getReplyProxyFrontend() {
    }

    default public Proxy getReplyProxy() {
    }

    default public Proxy getRequestProxy() {
    }
}

