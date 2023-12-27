/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.statusbar.modelapi;

import de.vw.mib.appadapter.statusbar.StatusbarAdapter;
import generated.de.vw.mib.appadapter.statusbar.InformationModelApiService;

public final class InformationModelApiServiceImpl
implements InformationModelApiService {
    private final StatusbarAdapter adapter;

    public InformationModelApiServiceImpl(StatusbarAdapter statusbarAdapter) {
        this.adapter = statusbarAdapter;
    }

    @Override
    public void _mda_statusbarShowIllumination() {
        this.adapter.enterIlluminationScreen();
    }
}

