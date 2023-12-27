/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.ErrorLog;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public class DSIAdapterErrorLog
implements IAdapterErrorLog {
    private final ErrorLog dispatcherErrors;
    private final ErrorLog providerErrors;

    public DSIAdapterErrorLog(int n) {
        this.dispatcherErrors = new ErrorLog(n);
        this.providerErrors = new ErrorLog(n);
    }

    @Override
    public void addDispatcherError(DispatcherInfo dispatcherInfo) {
        this.dispatcherErrors.add(dispatcherInfo);
    }

    @Override
    public IInfoBase[] getDispatcherErrors() {
        return this.dispatcherErrors.getAllEntries();
    }

    @Override
    public int getNumDroppedDispatcherErrors() {
        return this.dispatcherErrors.getNumDropped();
    }

    @Override
    public void addProviderError(ProviderInfo providerInfo) {
        this.providerErrors.add(providerInfo);
    }

    @Override
    public IInfoBase[] getProviderErrors() {
        return this.providerErrors.getAllEntries();
    }

    @Override
    public int getNumDroppedProviderErrors() {
        return this.providerErrors.getNumDropped();
    }

    @Override
    public int getAbsoluteDispatcherErrors() {
        int n = 0;
        if (this.dispatcherErrors.getAllEntries() != null) {
            n = this.dispatcherErrors.getAllEntries().length;
        }
        return n += this.dispatcherErrors.getNumDropped();
    }

    @Override
    public int getAbsoluteProviderErrors() {
        int n = 0;
        if (this.providerErrors.getAllEntries() != null) {
            n = this.providerErrors.getAllEntries().length;
        }
        return n += this.providerErrors.getNumDropped();
    }
}

