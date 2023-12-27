/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navhomeadressglobalwizardpage;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.navhomeadressglobalwizardpage.cio.NavHomeAdressGlobalWizardPageCioExecutor;
import de.vw.mib.appadapter.navhomeadressglobalwizardpage.modelapi.HomeAdressInputService;
import de.vw.mib.cio.CioExecutor;

public class NavHomeAdressGlobalWizardPageAdapter
extends AbstractAppAdapter {
    private ModelApiService[] apiServices;
    private static NavHomeAdressGlobalWizardPageCioExecutor EXECUTOR;
    private static AppAdapterSystemServices SYSTEM_SERVICES;
    static /* synthetic */ Class class$de$vw$mib$appadapter$navhomeadressglobalwizardpage$modelapi$HomeAdressInputService;

    public NavHomeAdressGlobalWizardPageAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        SYSTEM_SERVICES = appAdapterSystemServices;
    }

    public static AppAdapterSystemServices getSystemServices() {
        return SYSTEM_SERVICES;
    }

    public static NavHomeAdressGlobalWizardPageCioExecutor getExecutor() {
        if (EXECUTOR == null) {
            EXECUTOR = new NavHomeAdressGlobalWizardPageCioExecutor();
        }
        return EXECUTOR;
    }

    private ModelApiService getModelApiServiceInstance(Class clazz) {
        ModelApiService modelApiService = null;
        if (this.apiServices != null) {
            for (int i2 = 0; i2 < this.apiServices.length; ++i2) {
                if (!super.getClass().equals(clazz)) continue;
                modelApiService = this.apiServices[i2];
                break;
            }
        }
        return modelApiService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return NavHomeAdressGlobalWizardPageAdapter.getExecutor();
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        if (this.apiServices == null) {
            HomeAdressInputService homeAdressInputService = new HomeAdressInputService();
            this.apiServices = new ModelApiService[]{homeAdressInputService};
            NavHomeAdressGlobalWizardPageAdapter.getExecutor().registerService(homeAdressInputService);
        }
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
        ModelApiService modelApiService = this.getModelApiServiceInstance(class$de$vw$mib$appadapter$navhomeadressglobalwizardpage$modelapi$HomeAdressInputService == null ? (class$de$vw$mib$appadapter$navhomeadressglobalwizardpage$modelapi$HomeAdressInputService = NavHomeAdressGlobalWizardPageAdapter.class$("de.vw.mib.appadapter.navhomeadressglobalwizardpage.modelapi.HomeAdressInputService")) : class$de$vw$mib$appadapter$navhomeadressglobalwizardpage$modelapi$HomeAdressInputService);
        if (modelApiService != null) {
            HomeAdressInputService homeAdressInputService = (HomeAdressInputService)modelApiService;
            homeAdressInputService.ready();
        }
    }

    @Override
    public void stop() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

