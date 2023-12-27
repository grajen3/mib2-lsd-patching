/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.phonetiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.phonetiles.PhoneTileSAdapter$1;
import de.vw.mib.cio.CioExecutor;

public class PhoneTileSAdapter
extends AbstractAppAdapter {
    private static final int TILE_HEADER_BUTTON_ACTION;

    public PhoneTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new PhoneTileSAdapter$1(this);
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

    static /* synthetic */ AppAdapterSystemServices access$000(PhoneTileSAdapter phoneTileSAdapter) {
        return phoneTileSAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$100(PhoneTileSAdapter phoneTileSAdapter) {
        return phoneTileSAdapter.systemServices;
    }
}

