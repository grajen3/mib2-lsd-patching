/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASInvocationHandler;

public final class HASClient {
    private final int dsiInstance;
    private final String name;
    private final boolean adapterRequired;
    private HASInvocationHandler invocationAdapter;

    public HASClient(int n, String string, boolean bl) {
        this.dsiInstance = n;
        this.name = string;
        this.adapterRequired = bl;
    }

    public int getDSIInstance() {
        return this.dsiInstance;
    }

    public String getClientName() {
        return this.name;
    }

    public boolean isAdapterRequired() {
        return this.adapterRequired;
    }

    public HASInvocationHandler getInvocationAdapter() {
        return this.invocationAdapter;
    }

    public void setInvocationAdapter(HASInvocationHandler hASInvocationHandler) {
        this.invocationAdapter = hASInvocationHandler;
    }
}

