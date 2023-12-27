/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.IServiceHandlerCallback;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;

public interface IServiceHandlerListener {
    default public void serviceStubAttached(IService iService, int n, IStub iStub, IServiceHandlerCallback iServiceHandlerCallback) {
    }

    default public void serviceStubDetached(IService iService, int n, IStub iStub, IServiceHandlerCallback iServiceHandlerCallback) {
    }
}

