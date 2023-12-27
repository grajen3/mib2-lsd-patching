/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.dateglobalwizardpage;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.dateglobalwizardpage.DateGlobalWizardPageAdapter$1;
import de.vw.mib.appadapter.dateglobalwizardpage.modelapi.InformationModelApiServiceImpl;
import de.vw.mib.cio.CioExecutor;

public class DateGlobalWizardPageAdapter
extends AbstractAppAdapter {
    private InformationModelApiServiceImpl service = new InformationModelApiServiceImpl();
    private ModelApiService[] apiServices = new ModelApiService[]{this.service};

    public DateGlobalWizardPageAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new DateGlobalWizardPageAdapter$1(this);
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

    static /* synthetic */ InformationModelApiServiceImpl access$000(DateGlobalWizardPageAdapter dateGlobalWizardPageAdapter) {
        return dateGlobalWizardPageAdapter.service;
    }
}

