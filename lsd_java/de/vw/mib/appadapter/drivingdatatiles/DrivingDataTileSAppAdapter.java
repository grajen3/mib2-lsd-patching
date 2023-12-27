/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataService;
import de.vw.mib.cio.CioExecutor;

public class DrivingDataTileSAppAdapter
extends AbstractAppAdapter {
    private CarDrivingDataService carDrivingDataService;

    public DrivingDataTileSAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    private CarDrivingDataService getCarDrivingDataService() {
        if (this.carDrivingDataService == null) {
            this.carDrivingDataService = new CarDrivingDataService(this.systemServices);
        }
        return this.carDrivingDataService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this.getCarDrivingDataService();
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this.getCarDrivingDataService()};
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
        this.getCarDrivingDataService().start();
    }

    @Override
    public void stop() {
    }
}

