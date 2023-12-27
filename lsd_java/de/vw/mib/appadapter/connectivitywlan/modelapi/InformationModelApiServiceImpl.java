/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.connectivitywlan.modelapi;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioIntent;
import generated.de.vw.mib.appadapter.connectivitywlan.InformationModelApiService;

public final class InformationModelApiServiceImpl
implements InformationModelApiService {
    private final AppAdapterSystemServices systemServices;
    private CioIntent success;
    private CioIntent cancel;

    public InformationModelApiServiceImpl(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_onlineWizardSuccess() {
        if (this.success == null) {
            return;
        }
        this.systemServices.getCioDispatcher().dispatch(this.success);
        this.setCallbackCioIntents(null, null);
    }

    @Override
    public void _mda_onlineWizardCancel() {
        if (this.cancel == null) {
            return;
        }
        this.systemServices.getCioDispatcher().dispatch(this.cancel);
        this.setCallbackCioIntents(null, null);
    }

    public void setCallbackCioIntents(CioIntent cioIntent, CioIntent cioIntent2) {
        this.success = cioIntent;
        this.cancel = cioIntent2;
    }
}

