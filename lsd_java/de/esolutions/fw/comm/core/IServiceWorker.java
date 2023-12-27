/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IMethod;
import de.esolutions.fw.comm.core.IService;

public interface IServiceWorker {
    default public void registerService(IService iService) {
    }

    default public void unregisterService(IService iService) {
    }

    default public void stubCountChanged(IService iService, int n) {
    }

    default public void enqueueCall(IMethod iMethod) {
    }
}

