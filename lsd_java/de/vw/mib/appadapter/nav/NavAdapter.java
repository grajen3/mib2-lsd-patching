/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.nav;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.nav.cio.NavCioExecutor;
import de.vw.mib.appadapter.nav.modelapi.HomeAddressInputService;
import de.vw.mib.appadapter.nav.modelapi.ShowNavViewService;
import de.vw.mib.cio.CioExecutor;

public class NavAdapter
extends AbstractAppAdapter {
    private ModelApiService[] apiServices;
    private static NavCioExecutor EXECUTOR;
    private static AppAdapterSystemServices SYSTEM_SERVICES;

    public NavAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        SYSTEM_SERVICES = appAdapterSystemServices;
        this.initModelApiServices(appAdapterSystemServices);
    }

    private void initModelApiServices(AppAdapterSystemServices appAdapterSystemServices) {
        HomeAddressInputService homeAddressInputService = new HomeAddressInputService();
        ShowNavViewService showNavViewService = new ShowNavViewService();
        this.apiServices = new ModelApiService[]{homeAddressInputService, showNavViewService};
    }

    public static AppAdapterSystemServices getSystemServices() {
        return SYSTEM_SERVICES;
    }

    public static NavCioExecutor getExecutor() {
        if (EXECUTOR == null) {
            EXECUTOR = new NavCioExecutor();
        }
        return EXECUTOR;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return NavAdapter.getExecutor();
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

