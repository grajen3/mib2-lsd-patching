/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.base.IProviderStateListener;
import de.esolutions.fw.dsi.base.ProviderState;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public interface IProvider {
    default public void addProviderStateListener(IProviderStateListener iProviderStateListener) {
    }

    default public void removeProviderStateListener(IProviderStateListener iProviderStateListener) {
    }

    default public ProviderState getProviderState() {
    }

    default public void startProvider(boolean bl, IDSIServiceWorker iDSIServiceWorker) {
    }

    default public IDSIServiceWorker stopProvider() {
    }

    default public int getInstance() {
    }

    default public ProviderInfo getProviderInfo(int n) {
    }

    default public IDispatcher getDispatcher() {
    }
}

