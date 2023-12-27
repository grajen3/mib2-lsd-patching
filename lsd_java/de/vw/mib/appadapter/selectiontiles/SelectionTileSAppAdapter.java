/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.selectiontiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.selectiontiles.SelectionTileSAppAdapter$1;
import de.vw.mib.cio.CioExecutor;

public class SelectionTileSAppAdapter
extends AbstractAppAdapter {
    public SelectionTileSAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new SelectionTileSAppAdapter$1(this);
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return null;
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

