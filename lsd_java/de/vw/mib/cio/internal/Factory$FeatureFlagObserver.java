/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Factory;
import de.vw.mib.configuration.FeatureFlagValueChangeReceiver;

final class Factory$FeatureFlagObserver
implements FeatureFlagValueChangeReceiver {
    private final AbstractCio cio;
    private final CioExecutor cioExecutor;
    private final int featureFlagId;
    private final /* synthetic */ Factory this$0;

    Factory$FeatureFlagObserver(Factory factory, AbstractCio abstractCio, int n, CioExecutor cioExecutor) {
        this.this$0 = factory;
        this.cio = abstractCio;
        this.featureFlagId = n;
        this.cioExecutor = cioExecutor;
    }

    @Override
    public void receiveFeatureFlagValue(int n, boolean bl) {
        if (this.featureFlagId != n) {
            return;
        }
        if (bl && !this.cio.isRegistered()) {
            this.this$0.registerIfRequested(this.cio, this.cioExecutor);
        } else if (!bl && this.cio.isRegistered()) {
            this.cio.unregister();
        }
    }
}

