/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climatebar;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.asl.internal.car.api.climatebar.ClimateBarSeatControlService;
import de.vw.mib.cio.CioExecutor;

public class ClimateBarAppAdapter
extends AbstractAppAdapter {
    public static final int SEAT_INSTANCE_LEFT;
    public static final int SEAT_INSTANCE_RIGHT;
    private ClimateBarSeatControlService climateBarSeatControlService;

    public ClimateBarAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    private ClimateBarSeatControlService getClimateBarSeatControlService() {
        if (this.climateBarSeatControlService == null) {
            this.climateBarSeatControlService = new ClimateBarSeatControlService(this.systemServices);
        }
        return this.climateBarSeatControlService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return null;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this.getClimateBarSeatControlService()};
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
        this.getClimateBarSeatControlService().start();
    }

    @Override
    public void stop() {
    }
}

