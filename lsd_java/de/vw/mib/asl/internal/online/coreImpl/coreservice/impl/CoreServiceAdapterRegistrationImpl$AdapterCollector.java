/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.impl.CoreServiceAdapterRegistrationImpl;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapter;

class CoreServiceAdapterRegistrationImpl$AdapterCollector {
    private int _adapterID;
    private CoreServiceAdapter _adapter;
    private int _priority;
    private boolean _isAdapterUsable;
    private final /* synthetic */ CoreServiceAdapterRegistrationImpl this$0;

    public CoreServiceAdapterRegistrationImpl$AdapterCollector(CoreServiceAdapterRegistrationImpl coreServiceAdapterRegistrationImpl) {
        this.this$0 = coreServiceAdapterRegistrationImpl;
    }

    public int getAdapterID() {
        return this._adapterID;
    }

    public void setAdapterID(int n) {
        this._adapterID = n;
    }

    public CoreServiceAdapter getAdapter() {
        return this._adapter;
    }

    public void setAdapter(CoreServiceAdapter coreServiceAdapter) {
        this._adapter = coreServiceAdapter;
    }

    public int getPriority() {
        return this._priority;
    }

    public void setPriority(int n) {
        this._priority = n;
    }

    public boolean isAdapterUsable() {
        return this._isAdapterUsable;
    }

    public void setAdapterUsable(boolean bl) {
        this._isAdapterUsable = bl;
    }
}

