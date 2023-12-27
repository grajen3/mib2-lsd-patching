/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tvtuner;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.tvtuner.TVTunerSpaceGesturesModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

public class TVTunerAdapter
extends AbstractAppAdapter
implements CioExecutor,
ModelApiService {
    private TVTunerSpaceGesturesModelApiService tvtunerSpaceGesturesModelApiService;

    public TVTunerAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this, this.getTVTunerSpaceGesturesModelApiService()};
        return modelApiServiceArray;
    }

    private TVTunerSpaceGesturesModelApiService getTVTunerSpaceGesturesModelApiService() {
        if (this.tvtunerSpaceGesturesModelApiService == null) {
            this.tvtunerSpaceGesturesModelApiService = new TVTunerSpaceGesturesModelApiService(this.systemServices);
        }
        return this.tvtunerSpaceGesturesModelApiService;
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

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

