/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public interface IAdapterErrorLog {
    default public void addDispatcherError(DispatcherInfo dispatcherInfo) {
    }

    default public IInfoBase[] getDispatcherErrors() {
    }

    default public int getNumDroppedDispatcherErrors() {
    }

    default public int getAbsoluteDispatcherErrors() {
    }

    default public void addProviderError(ProviderInfo providerInfo) {
    }

    default public IInfoBase[] getProviderErrors() {
    }

    default public int getNumDroppedProviderErrors() {
    }

    default public int getAbsoluteProviderErrors() {
    }
}

