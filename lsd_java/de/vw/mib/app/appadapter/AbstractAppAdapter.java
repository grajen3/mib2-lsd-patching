/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.cio.CioExecutor;

public abstract class AbstractAppAdapter {
    protected final AppAdapterSystemServices systemServices;

    public AbstractAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    public abstract CioExecutor getCioExecutor() {
    }

    public abstract ModelApiService[] getModelApiServices() {
    }

    public abstract void init(int n, String string) {
    }

    public abstract void start() {
    }

    public abstract void ready() {
    }

    public abstract void stop() {
    }
}

