/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.thinkbluetiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.thinkbluetiles.CarTBTBluePointsService;
import de.vw.mib.appadapter.thinkbluetiles.CarTBTConsumptionService;
import de.vw.mib.appadapter.thinkbluetiles.CarTBTGeneralService;
import de.vw.mib.appadapter.thinkbluetiles.CarTBTIrisService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;

public class ThinkBlueTileSAppAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    static final String CIO_ACTION_SHOW_CAR_VIEW_PARAM__CONTEXT;
    static final String CAR_TBT_VIEW;
    private CarTBTGeneralService carTBTGeneralService;
    private CarTBTBluePointsService carTBTBluePointsService;
    private CarTBTConsumptionService carTBTConsumptionService;
    private CarTBTIrisService carTBTIrisService;

    public ThinkBlueTileSAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    private CarTBTGeneralService getCarTBTGeneralService() {
        if (this.carTBTGeneralService == null) {
            this.carTBTGeneralService = new CarTBTGeneralService(this.systemServices);
        }
        return this.carTBTGeneralService;
    }

    private CarTBTBluePointsService getCarTBTBluePointsService() {
        if (this.carTBTBluePointsService == null) {
            this.carTBTBluePointsService = new CarTBTBluePointsService(this.systemServices);
        }
        return this.carTBTBluePointsService;
    }

    private CarTBTConsumptionService getCarTBTConsumptionService() {
        if (this.carTBTConsumptionService == null) {
            this.carTBTConsumptionService = new CarTBTConsumptionService(this.systemServices);
        }
        return this.carTBTConsumptionService;
    }

    private CarTBTIrisService getCarTBTIrisService() {
        if (this.carTBTIrisService == null) {
            this.carTBTIrisService = new CarTBTIrisService(this.systemServices);
        }
        return this.carTBTIrisService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this.getCarTBTGeneralService(), this.getCarTBTIrisService()};
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
        this.getCarTBTGeneralService().start();
        this.getCarTBTBluePointsService().start();
        this.getCarTBTConsumptionService().start();
        this.getCarTBTIrisService().start();
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                CioActionParameters cioActionParameters2 = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarTbtView").finishActionParams();
                this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters2);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }
}

