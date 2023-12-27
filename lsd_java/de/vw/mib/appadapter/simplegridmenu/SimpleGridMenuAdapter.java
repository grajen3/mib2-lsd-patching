/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.simplegridmenu;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.simplegridmenu.GesturesModelApiServiceImpl;
import de.vw.mib.appadapter.simplegridmenu.SimpleGridMenuAdapter$1;
import de.vw.mib.cio.CioExecutor;

public final class SimpleGridMenuAdapter
extends AbstractAppAdapter {
    public SimpleGridMenuAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new SimpleGridMenuAdapter$1(this);
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{new GesturesModelApiServiceImpl(this.systemServices)};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }
}

