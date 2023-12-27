/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.phoneglobalwizardpage;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.phoneglobalwizardpage.PhoneGlobalWizardPageAdapter$1;
import de.vw.mib.appadapter.phoneglobalwizardpage.modelapi.InformationModelApiServiceImpl;
import de.vw.mib.cio.CioExecutor;

public class PhoneGlobalWizardPageAdapter
extends AbstractAppAdapter {
    InformationModelApiServiceImpl service = new InformationModelApiServiceImpl();
    private ModelApiService[] apiServices = new ModelApiService[]{this.service};

    public PhoneGlobalWizardPageAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new PhoneGlobalWizardPageAdapter$1(this);
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
}

