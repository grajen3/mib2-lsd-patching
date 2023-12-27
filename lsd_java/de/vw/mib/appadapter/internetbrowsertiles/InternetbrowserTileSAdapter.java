/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.internetbrowsertiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.internetbrowsertiles.InternetbrowserTileSAdapter$1;
import de.vw.mib.appadapter.internetbrowsertiles.InternetbrowserTileSAdapter$2;
import de.vw.mib.cio.CioExecutor;

public class InternetbrowserTileSAdapter
extends AbstractAppAdapter {
    private static final int TILE_HEADER_BUTTON_ACTION;

    public InternetbrowserTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new InternetbrowserTileSAdapter$1(this);
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{new InternetbrowserTileSAdapter$2(this)};
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

    static /* synthetic */ AppAdapterSystemServices access$000(InternetbrowserTileSAdapter internetbrowserTileSAdapter) {
        return internetbrowserTileSAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$100(InternetbrowserTileSAdapter internetbrowserTileSAdapter) {
        return internetbrowserTileSAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$200(InternetbrowserTileSAdapter internetbrowserTileSAdapter) {
        return internetbrowserTileSAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$300(InternetbrowserTileSAdapter internetbrowserTileSAdapter) {
        return internetbrowserTileSAdapter.systemServices;
    }
}

