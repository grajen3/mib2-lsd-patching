/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tunerautostoreglobalwizardpage;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.tunerautostoreglobalwizardpage.ApiAppAdapterTunerAutostore;
import de.vw.mib.appadapter.tunerautostoreglobalwizardpage.TunerAutostoreGlobalWizardPageAdapter$1;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

public final class TunerAutostoreGlobalWizardPageAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private ApiAppAdapterTunerAutostore service;
    private ModelApiService[] apiServices;

    public TunerAutostoreGlobalWizardPageAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.service = new ApiAppAdapterTunerAutostore(appAdapterSystemServices);
        this.apiServices = new ModelApiService[]{this.service};
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return this.apiServices;
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
    public CioExecutor getCioExecutor() {
        return new TunerAutostoreGlobalWizardPageAdapter$1(this);
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
    }

    static /* synthetic */ ApiAppAdapterTunerAutostore access$000(TunerAutostoreGlobalWizardPageAdapter tunerAutostoreGlobalWizardPageAdapter) {
        return tunerAutostoreGlobalWizardPageAdapter.service;
    }
}

