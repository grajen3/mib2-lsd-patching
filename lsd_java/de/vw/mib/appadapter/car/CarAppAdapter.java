/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.car;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.car.CarPersonalizationService;
import de.vw.mib.appadapter.car.CioExecutorProxy;
import de.vw.mib.appadapter.car.GeneralModelApiServiceImpl;
import de.vw.mib.appadapter.car.GestureService;
import de.vw.mib.appadapter.car.ShowActualViewsService;
import de.vw.mib.appadapter.car.SystemSetupModelApiServiceImpl;
import de.vw.mib.cio.CioExecutor;
import generated.de.vw.mib.appadapter.car.GeneralModelApiService;
import generated.de.vw.mib.appadapter.car.SystemSetupModelApiService;

public class CarAppAdapter
extends AbstractAppAdapter {
    private CioExecutorProxy cioExecutorproxy;
    private CarPersonalizationService personalizationService;
    private ShowActualViewsService showActualViewsService;
    private GestureService gestureService;
    private final GeneralModelApiService generalModelApiService;
    private final SystemSetupModelApiService systemSetupService;

    public CarAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.personalizationService = new CarPersonalizationService(this.systemServices);
        this.generalModelApiService = new GeneralModelApiServiceImpl(appAdapterSystemServices);
        this.systemSetupService = new SystemSetupModelApiServiceImpl(appAdapterSystemServices);
    }

    private CarPersonalizationService getCarPersonalizationService() {
        if (this.personalizationService == null) {
            this.personalizationService = new CarPersonalizationService(this.systemServices);
        }
        return this.personalizationService;
    }

    private ShowActualViewsService getShowActualViewsService() {
        if (this.showActualViewsService == null) {
            this.showActualViewsService = new ShowActualViewsService(this.systemServices);
        }
        return this.showActualViewsService;
    }

    private CioExecutorProxy getCioExecutorProxy() {
        if (this.cioExecutorproxy == null) {
            this.cioExecutorproxy = new CioExecutorProxy(new CioExecutor[]{this.getCarPersonalizationService(), this.getShowActualViewsService()});
        }
        return this.cioExecutorproxy;
    }

    private GestureService getGestureService() {
        if (this.gestureService == null) {
            this.gestureService = new GestureService(this.systemServices);
        }
        return this.gestureService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this.getCioExecutorProxy();
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this.getCarPersonalizationService(), this.getShowActualViewsService(), this.getGestureService(), this.generalModelApiService, this.systemSetupService};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void ready() {
    }

    @Override
    public void start() {
        this.getCarPersonalizationService().start();
        this.getGestureService().start();
    }

    @Override
    public void stop() {
    }
}

