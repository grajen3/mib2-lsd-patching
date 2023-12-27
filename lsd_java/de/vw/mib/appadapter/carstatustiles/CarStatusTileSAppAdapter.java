/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.carstatustiles.CarStatusMainService;
import de.vw.mib.appadapter.carstatustiles.CarStatusOilService;
import de.vw.mib.appadapter.carstatustiles.CarStatusTiresService;
import de.vw.mib.appadapter.carstatustiles.CarStatusViewOptionsService;
import de.vw.mib.appadapter.carstatustiles.GeneralService;
import de.vw.mib.cio.CioExecutor;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusMainModelApiService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusOilModelApiService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusTiresModelApiService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusViewOptionsModelApiService;

public class CarStatusTileSAppAdapter
extends AbstractAppAdapter {
    private GeneralService generalSevice;
    private CarStatusMainService carStatusMainService;
    private CarStatusOilService carStatusOilService;
    private CarStatusTiresService carStatusTiresService;
    private CarStatusViewOptionsService carStatusViewOptionsService;

    public CarStatusTileSAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    private GeneralService getGeneralService() {
        if (this.generalSevice == null) {
            this.generalSevice = new GeneralService(this.systemServices);
        }
        return this.generalSevice;
    }

    private CarStatusMainService getCarStatusMainService() {
        if (this.carStatusMainService == null) {
            this.carStatusMainService = new CarStatusMainService(this.systemServices);
        }
        return this.carStatusMainService;
    }

    private CarStatusOilService getCarStatusOilService() {
        if (this.carStatusOilService == null) {
            this.carStatusOilService = new CarStatusOilService(this.systemServices);
        }
        return this.carStatusOilService;
    }

    private CarStatusTiresService getCarStatusTiresService() {
        if (this.carStatusTiresService == null) {
            this.carStatusTiresService = new CarStatusTiresService(this.systemServices);
        }
        return this.carStatusTiresService;
    }

    private CarStatusViewOptionsService getCarStatusViewOptionsService() {
        if (this.carStatusViewOptionsService == null) {
            this.carStatusViewOptionsService = new CarStatusViewOptionsService(this.systemServices);
        }
        return this.carStatusViewOptionsService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this.getGeneralService();
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this.getGeneralService(), new CarStatusMainModelApiService(), new CarStatusOilModelApiService(), new CarStatusTiresModelApiService(), new CarStatusViewOptionsModelApiService()};
        return modelApiServiceArray;
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void ready() {
    }

    @Override
    public void start() {
        this.getGeneralService().start();
        this.getCarStatusMainService().start();
        this.getCarStatusOilService().start();
        this.getCarStatusTiresService().start();
        this.getCarStatusViewOptionsService().start();
    }

    @Override
    public void stop() {
    }
}

