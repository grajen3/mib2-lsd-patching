/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.IMethodHandler;

public interface IService
extends IMethodHandler {
    default public ServiceInstanceID getInstanceID() {
    }

    default public IProxyFrontend createReplyProxy() {
    }

    default public CallContext getCallContext() {
    }
}

