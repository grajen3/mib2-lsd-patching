/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;

public interface IServiceListener {
    default public void serviceStubCountChanged(IService iService, int n) {
    }

    default public void serviceStubAttached(IStub iStub) {
    }

    default public void serviceStubDetached(IStub iStub) {
    }
}

