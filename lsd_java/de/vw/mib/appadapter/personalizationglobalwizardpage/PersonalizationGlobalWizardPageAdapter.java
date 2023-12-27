/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.personalizationglobalwizardpage;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.personalizationglobalwizardpage.ProfileNameInputModelApiServiceImpl;
import de.vw.mib.cio.CioExecutor;

public class PersonalizationGlobalWizardPageAdapter
extends AbstractAppAdapter {
    private ProfileNameInputModelApiServiceImpl modelApiProfileNameService;

    public PersonalizationGlobalWizardPageAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.modelApiProfileNameService = new ProfileNameInputModelApiServiceImpl(this.systemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this.modelApiProfileNameService;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this.modelApiProfileNameService};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
        this.modelApiProfileNameService.start();
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }
}

